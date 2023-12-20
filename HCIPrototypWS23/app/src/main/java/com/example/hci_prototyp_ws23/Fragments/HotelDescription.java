package com.example.hci_prototyp_ws23.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.hci_prototyp_ws23.Models.Hotel;
import com.example.hci_prototyp_ws23.Models.RoomType;
import com.example.hci_prototyp_ws23.Models.User;
import com.example.hci_prototyp_ws23.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class HotelDescription extends Fragment {
    View view;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    TextView hotelNameTextView, checkInDateTextView, checkOutDateTextView, roomsAndGuestTextView, totalPriceTextView, hotelAddressTextView;
    Button seeYourOptionsButton;
    Hotel hotel;
    User user;
    int numberOfRooms, adultsNumber, childrenNumber;
    RoomType roomType;
    Date checkInDate = new Date();
    Date checkOutDate = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_hotel_description, container, false);
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_bar);
        toolbar = view.findViewById(R.id.hotelDescription_tb);
        hotelNameTextView = view.findViewById(R.id.hotelName_tv);
        checkInDateTextView = view.findViewById(R.id.checkInDate_tv);
        checkOutDateTextView = view.findViewById(R.id.checkOutDate_tv);
        roomsAndGuestTextView = view.findViewById(R.id.roomsAndGuests_tv);
        totalPriceTextView = view.findViewById(R.id.totalPrice_tv);
        hotelAddressTextView = view.findViewById(R.id.hotelAddress_tv);
        seeYourOptionsButton = view.findViewById(R.id.seeYourOptions_btn);

        user = HotelDescriptionArgs.fromBundle(getArguments()).getUserArg();
        hotel = HotelDescriptionArgs.fromBundle(getArguments()).getHotelArg();
        roomType = HotelDescriptionArgs.fromBundle(getArguments()).getRoomTypeArg();
        numberOfRooms = HotelDescriptionArgs.fromBundle(getArguments()).getNumberOfRoomsArg();
        adultsNumber = HotelDescriptionArgs.fromBundle(getArguments()).getAdultsNumberArg();
        childrenNumber = HotelDescriptionArgs.fromBundle(getArguments()).getChildrenNumberArg();
        Toast.makeText(getContext(), user.getUsername() + " and " + hotel.getHotelName(), Toast.LENGTH_SHORT).show();

        try {
            checkInDate = sdf.parse(HotelDescriptionArgs.fromBundle(getArguments()).getCheckInDate());
            checkOutDate = sdf.parse(HotelDescriptionArgs.fromBundle(getArguments()).getCheckOutDate());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        roomType = hotel.getRoomTypeList().get(0);
        for(RoomType room: hotel.getRoomTypeList()) {
            if(room.getPricePerNight() < roomType.getPricePerNight()) {
                roomType = room;
            }
        }
        return view;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView.setVisibility(View.GONE);
        toolbar.setVisibility(View.VISIBLE);
        toolbar.setTitle(hotel.getHotelName());
        toolbar.inflateMenu(R.menu.top_action_bar_hotel_description);
        toolbar.setNavigationOnClickListener(v -> NavHostFragment.findNavController(HotelDescription.this).popBackStack());
        seeYourOptionsButton.setOnClickListener(v -> {
            HotelDescriptionDirections.ActionHotelDescriptionToUserInfoOverview action = HotelDescriptionDirections.actionHotelDescriptionToUserInfoOverview(user, hotel, roomType, sdf.format(checkInDate), sdf.format(checkOutDate), adultsNumber, childrenNumber, numberOfRooms);
            NavHostFragment.findNavController(HotelDescription.this).navigate(action);
            }
        );
        hotelNameTextView.setText(hotel.getHotelName());
        checkInDateTextView.setText("Check-in" + "\n" + sdf.format(checkInDate));
        checkOutDateTextView.setText("Check-out" + "\n" + sdf.format(checkOutDate));
            roomsAndGuestTextView.setText("Rooms and guests" + "\n" + numberOfRooms + " room " + adultsNumber + " adults " + childrenNumber + " children");

        long nights = TimeUnit.MILLISECONDS.toDays(checkOutDate.getTime() - checkInDate.getTime());
        totalPriceTextView.setText("Price for " + nights + " nights/room" + "\n" + roomType.getPricePerNight() * nights + " €");
        hotelAddressTextView.setText(hotel.getHotelAddress().getStreetAddress() + " " + hotel.getHotelAddress().getCity() + "\n" + hotel.getHotelAddress().getPostalCode() + " " + hotel.getHotelAddress().getCountry());
    }
}
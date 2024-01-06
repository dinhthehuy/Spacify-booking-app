package com.example.hci_prototyp_ws23.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.fragment.NavHostFragment;
import android.widget.Button;

import com.example.hci_prototyp_ws23.Models.Hotel;
import com.example.hci_prototyp_ws23.Models.User;
import com.example.hci_prototyp_ws23.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class PaymentMethod extends Fragment {

   View view;
    BottomNavigationView bottomNavigationView;
    Button roomInfoButton;
    Toolbar toolbar;
    User user;
    Hotel hotel;
    String checkInDate, checkOutDate;
    int adultsNumber, childrenNumber, numberOfRooms;
    double totalPrice;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_payment_method, container, false);
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_bar);
        toolbar = view.findViewById(R.id.paymentMethod_tb);
        roomInfoButton = view.findViewById(R.id.paymentMethod_btn);

        user = PaymentMethodArgs.fromBundle(getArguments()).getUserArg();
        hotel = PaymentMethodArgs.fromBundle(getArguments()).getHotelArg();
        checkInDate = PaymentMethodArgs.fromBundle(getArguments()).getCheckInDateArg();
        checkOutDate = PaymentMethodArgs.fromBundle(getArguments()).getCheckOutDateArg();
        adultsNumber = PaymentMethodArgs.fromBundle(getArguments()).getAdultsNumberArg();
        childrenNumber = PaymentMethodArgs.fromBundle(getArguments()).getChildrenNumberArg();
        numberOfRooms = PaymentMethodArgs.fromBundle(getArguments()).getNumberOfRoomsArg();
        totalPrice = PaymentMethodArgs.fromBundle(getArguments()).getTotalPriceArg();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView.setVisibility(View.GONE);
        toolbar.setVisibility(View.VISIBLE);
        toolbar.inflateMenu(R.menu.top_action_bar_room_information);
        toolbar.setNavigationOnClickListener(v -> NavHostFragment.findNavController(PaymentMethod.this).popBackStack());
        roomInfoButton.setOnClickListener(v -> {
            PaymentMethodDirections.ActionPaymentMethodToBookingConfimation action = PaymentMethodDirections.actionPaymentMethodToBookingConfimation(user.getEmail());
            NavHostFragment.findNavController(PaymentMethod.this).navigate(action);
        });
    }
}
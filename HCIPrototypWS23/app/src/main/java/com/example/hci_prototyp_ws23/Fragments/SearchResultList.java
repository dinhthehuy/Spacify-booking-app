package com.example.hci_prototyp_ws23.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hci_prototyp_ws23.Adapters.SearchResultListAdapter;
import com.example.hci_prototyp_ws23.Models.Address;
import com.example.hci_prototyp_ws23.Models.Hotel;
import com.example.hci_prototyp_ws23.Models.RoomType;
import com.example.hci_prototyp_ws23.Models.User;
import com.example.hci_prototyp_ws23.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class SearchResultList extends Fragment {
    View view;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    RecyclerView recyclerView;
    User user;
    String destination;
    String checkInDate;
    int numberOfRooms;
    int adultNumber;
    int childrenNumber;
    String checkOutDate;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_search_result_list, container, false);
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_bar);
        toolbar = view.findViewById(R.id.searchResultList_tb);
        recyclerView = view.findViewById(R.id.searchResultList_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (getArguments() != null) {
            user = SearchResultListArgs.fromBundle(getArguments()).getUserArg();
            destination = SearchResultListArgs.fromBundle(getArguments()).getDestinationArg();
            numberOfRooms = SearchResultListArgs.fromBundle(getArguments()).getNumberOfRoomsArg();
            adultNumber = SearchResultListArgs.fromBundle(getArguments()).getAdultsNumberArg();
            childrenNumber = SearchResultListArgs.fromBundle(getArguments()).getChildrenNumberArg();
            checkInDate = SearchResultListArgs.fromBundle(getArguments()).getCheckInDate();
            checkOutDate = SearchResultListArgs.fromBundle(getArguments()).getCheckOutDate();
        }

        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel("Mercure", new Address("United States", "New York", "123 Main St", 10001),""));
        hotels.get(0).getRoomTypeList().add(new RoomType("Singe room", 15, 2, 1, 20, 80.5));

        hotels.add(new Hotel("Azure Haven Hotel", new Address("United States", "California", "325 Serenity Lane", 90210),""));
        hotels.get(1).getRoomTypeList().add(new RoomType("Singe room", 17, 2, 2, 16, 90));

        hotels.add(new Hotel("Crimson Crown Inn", new Address("United States", "New York", "112 Royal Street, Regal City", 10001),""));
        hotels.get(2).getRoomTypeList().add(new RoomType("Singe room", 20, 2, 2, 20, 80.5));

        hotels.add(new Hotel("Mystic Oasis Resort", new Address("United States", "Florida", "500 Enchanted Grove, Mystical Springs", 33123),""));
        hotels.get(3).getRoomTypeList().add(new RoomType("Singe room", 15, 2, 1, 20, 82));

        hotels.add(new Hotel("Radiant Horizon Hotel", new Address("United States", "Texas", "75 Luminous Boulevard, Radiant City", 75234),""));
        hotels.get(4).getRoomTypeList().add(new RoomType("Singe room", 18, 2, 1, 20, 85.5));

        hotels.add(new Hotel("Alpine Haven Lodge", new Address("United States", "Los Angeles", "200 Snowfall Lane, Alpine Peaks", 80345),""));
        hotels.get(5).getRoomTypeList().add(new RoomType("Singe room", 17, 2, 1, 20, 75.5));

        SearchResultListAdapter searchResultListAdapter = new SearchResultListAdapter(hotels);
        recyclerView.setAdapter(searchResultListAdapter);
        searchResultListAdapter.setOnClickListener((position, hotel) -> {
            SearchResultListDirections.ActionSearchResultListToHotelDescription action = SearchResultListDirections.actionSearchResultListToHotelDescription(user, hotel, hotel.getRoomTypeList().get(0), adultNumber, childrenNumber, checkInDate, checkOutDate, numberOfRooms);
            NavHostFragment.findNavController(SearchResultList.this).navigate(action);
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView.setVisibility(View.GONE);
        toolbar.setVisibility(View.VISIBLE);
        toolbar.setTitle("Search Result");
        toolbar.inflateMenu(R.menu.top_action_bar_search_result);
        toolbar.setNavigationOnClickListener(v -> NavHostFragment.findNavController(SearchResultList.this).popBackStack());
    }
}
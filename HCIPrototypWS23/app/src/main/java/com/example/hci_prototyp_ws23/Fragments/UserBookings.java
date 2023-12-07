package com.example.hci_prototyp_ws23.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hci_prototyp_ws23.Adapters.UserBookingsAdapter;
import com.example.hci_prototyp_ws23.Models.Address;
import com.example.hci_prototyp_ws23.Models.Hotel;
import com.example.hci_prototyp_ws23.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class UserBookings extends Fragment {
    View view;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_your_bookings, container, false);
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_bar);
        toolbar = view.findViewById(R.id.userBookings_tb);
        recyclerView = view.findViewById(R.id.userBookings_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel("The Villa Britania Platinum House", new Address("United States", "New York", "123 Main St", 10001),""));
        hotels.add(new Hotel("The Villa Britania Platinum House", new Address("United States", "New York", "123 Main St", 10001),""));
        hotels.add(new Hotel("The Villa Britania Platinum House", new Address("United States", "New York", "123 Main St", 10001),""));
        hotels.add(new Hotel("The Villa Britania Platinum House", new Address("United States", "New York", "123 Main St", 10001),""));
        hotels.add(new Hotel("The Villa Britania Platinum House", new Address("United States", "New York", "123 Main St", 10001),""));
        hotels.add(new Hotel("The Villa Britania Platinum House", new Address("United States", "New York", "123 Main St", 10001),""));

        UserBookingsAdapter userBookingsAdapter = new UserBookingsAdapter(hotels);
        recyclerView.setAdapter(userBookingsAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView.setVisibility(View.VISIBLE);
        bottomNavigationView.getMenu().getItem(2).setChecked(true);
        toolbar.setVisibility(View.VISIBLE);
        toolbar.inflateMenu(R.menu.top_action_bar_user_bookings);
    }
}
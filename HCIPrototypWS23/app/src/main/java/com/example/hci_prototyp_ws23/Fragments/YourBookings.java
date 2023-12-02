package com.example.hci_prototyp_ws23.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hci_prototyp_ws23.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class YourBookings extends Fragment {
    View view;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_your_bookings, container, false);
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_bar);
        toolbar = view.findViewById(R.id.your_bookings_tb);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView.setVisibility(View.VISIBLE);
        bottomNavigationView.getMenu().getItem(2).setChecked(true);
        toolbar.setVisibility(View.VISIBLE);
        toolbar.setTitle("Bookings");
        toolbar.setTitleMarginStart(425);
        toolbar.inflateMenu(R.menu.top_action_bar_bookings);
    }
}
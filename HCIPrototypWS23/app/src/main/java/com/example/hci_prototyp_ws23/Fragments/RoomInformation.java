package com.example.hci_prototyp_ws23.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.hci_prototyp_ws23.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RoomInformation extends Fragment {
    View view;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    Button roomInfoButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_room_information, container, false);
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_bar);
        toolbar = view.findViewById(R.id.room_info_tb);
        roomInfoButton = view.findViewById(R.id.roomInfo_btn);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView.setVisibility(View.GONE);
        toolbar.setVisibility(View.VISIBLE);
        //toolbar.setTitle("Choose a room");
        toolbar.inflateMenu(R.menu.top_action_bar_room_information);
        toolbar.setNavigationOnClickListener(v -> NavHostFragment.findNavController(RoomInformation.this).navigate(R.id.action_roomInformation_to_userInfoOverview));
        roomInfoButton.setOnClickListener(v -> NavHostFragment.findNavController(RoomInformation.this).navigate(R.id.action_roomInformation_to_bookingConfimation));
    }
}
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

import com.example.hci_prototyp_ws23.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Homepage extends Fragment {
    View view;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_homepage, container, false);
        toolbar = view.findViewById(R.id.homepage_tb);
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_bar);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView.setVisibility(View.VISIBLE);
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        String email = "User";
        if(getArguments() != null) {
            email = HomepageArgs.fromBundle(getArguments()).getEmailArg();
        }
        toolbar.setVisibility(View.VISIBLE);
        toolbar.setTitle("Hi " + email);
        toolbar.getMenu().getItem(0).setOnMenuItemClickListener(item -> {
            NavHostFragment.findNavController(Homepage.this).navigate(R.id.action_homepage_to_search);
            return true;
        });

    }
}
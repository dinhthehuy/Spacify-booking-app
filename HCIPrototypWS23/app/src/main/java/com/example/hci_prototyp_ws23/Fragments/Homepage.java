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

import com.example.hci_prototyp_ws23.DatabaseHelper;
import com.example.hci_prototyp_ws23.Models.User;
import com.example.hci_prototyp_ws23.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Homepage extends Fragment {
    View view;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    DatabaseHelper databaseHelper;
    User currentUser;
    FirebaseAuth mAuth;
    FirebaseUser user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_homepage, container, false);
        toolbar = view.findViewById(R.id.homepage_tb);
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_bar);
        databaseHelper = DatabaseHelper.getInstance(getContext());
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView.setVisibility(View.VISIBLE);
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        currentUser = databaseHelper.readUserBy("email", user.getEmail());
        toolbar.setVisibility(View.VISIBLE);
        toolbar.setTitle("Hi " + currentUser.getUsername() + " !");
        toolbar.getMenu().getItem(0).setOnMenuItemClickListener(item -> {
            HomepageDirections.ActionHomepageToSearch action = HomepageDirections.actionHomepageToSearch(currentUser);
            NavHostFragment.findNavController(Homepage.this).navigate(action);
            return true;
        });


    }
}
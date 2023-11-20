package com.example.hci_prototyp_ws23.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.hci_prototyp_ws23.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LogIn extends Fragment {
    View view;
    Button loginBtn;
    BottomNavigationView bottomNavigationView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_log_in, container, false);
        loginBtn = view.findViewById(R.id.login_btn);
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_bar);
         return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView.setVisibility(View.GONE);
        loginBtn.setOnClickListener(v -> NavHostFragment.findNavController(LogIn.this).navigate(R.id.action_logIn_to_homepage));
    }
}
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

import com.example.hci_prototyp_ws23.Models.Address;
import com.example.hci_prototyp_ws23.Models.User;
import com.example.hci_prototyp_ws23.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Homepage extends Fragment {
    View view;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    List<User> userList = new ArrayList<>();
    User testUser = new User("dinhthehuy", "Dinh", "The Huy", "admin@gmail.com", "123456", new Address("Germany", "Darmstadt", "Street", 13),  new Date(100), User.Gender.MALE);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_homepage, container, false);
        toolbar = view.findViewById(R.id.homepage_tb);
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_bar);
        userList.add(testUser);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView.setVisibility(View.VISIBLE);
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        String username = "";
        if(getArguments() != null) {
            String email = HomepageArgs.fromBundle(getArguments()).getEmailArg();
            for (User user: userList) {
                if(Objects.equals(user.getEmail(), email)) {
                    username = user.getUsername();
                    break;
                }
            }
        }
        toolbar.setVisibility(View.VISIBLE);
        toolbar.setTitle("Hi " + username + " !");
        toolbar.getMenu().getItem(0).setOnMenuItemClickListener(item -> {
            HomepageDirections.ActionHomepageToSearch action = HomepageDirections.actionHomepageToSearch(testUser);
            NavHostFragment.findNavController(Homepage.this).navigate(action);
            return true;
        });

    }
}
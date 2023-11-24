package com.example.hci_prototyp_ws23.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hci_prototyp_ws23.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchResultList extends Fragment {
    View view;
    BottomNavigationView bottomNavigationView;
    Button back_button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_search_result_list, container, false);
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_bar);
        back_button = view.findViewById(R.id.back_btn);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView.setVisibility(View.VISIBLE);

        back_button.setOnClickListener(v -> NavHostFragment.findNavController(SearchResultList.this).navigate(R.id.action_searchResultList_to_homepage));
    }
}
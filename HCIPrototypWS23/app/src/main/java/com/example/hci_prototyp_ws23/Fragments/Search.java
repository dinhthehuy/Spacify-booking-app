package com.example.hci_prototyp_ws23.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hci_prototyp_ws23.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Search extends Fragment {
    View view;
    BottomNavigationView bottomNavigationView;
    Button search_button;
    TextView date_textView;
    Toolbar toolbar;
    EditText destinationEditText;
    EditText roomNumberEditText;
    EditText adultNumberEditText;
    EditText childrenNumberEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_search, container, false);
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_bar);
        toolbar = view.findViewById(R.id.search_tb);
        toolbar = view.findViewById(R.id.search_tb);
        search_button = view.findViewById(R.id.search_btn);
        date_textView = view.findViewById(R.id.date_edt);
        destinationEditText = view.findViewById(R.id.destination_edt);
        roomNumberEditText = view.findViewById(R.id.roomNumber_edt);
        adultNumberEditText = view.findViewById(R.id.adultNumber_edt);
        childrenNumberEditText = view.findViewById(R.id.childrenNumber_edt);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView.setVisibility(View.GONE);
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        toolbar.setNavigationOnClickListener(v -> NavHostFragment.findNavController(Search.this).navigate(R.id.action_search_to_homepage));
        search_button.setOnClickListener(v -> {
            String destination = destinationEditText.getText().toString();
            String date = date_textView.getText().toString();
            int roomNumber = Integer.parseInt(roomNumberEditText.getText().toString());
            int adultNumber = Integer.parseInt(adultNumberEditText.getText().toString());
            int childrenNumber = Integer.parseInt(childrenNumberEditText.getText().toString());

            SearchDirections.ActionSearchToSearchResultList action =
                    SearchDirections.actionSearchToSearchResultList(destination, date, roomNumber, adultNumber, childrenNumber);
            NavHostFragment.findNavController(Search.this).navigate(action);
        });

        date_textView.setOnClickListener(v -> {
            MaterialDatePicker.Builder<Pair<Long, Long>> materialDatePickerBuilder = MaterialDatePicker.Builder.dateRangePicker();
            materialDatePickerBuilder.setTitleText("Select a date range");
            MaterialDatePicker<Pair<Long, Long>> datePicker = materialDatePickerBuilder.build();
            datePicker.addOnPositiveButtonClickListener(selection -> {
                Long startDate = selection.first;
                Long endDate = selection.second;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                String startDateString = sdf.format(new Date(startDate));
                String endDateString = sdf.format(new Date(endDate));
                String selectedDateRange = startDateString + " - " + endDateString;
                date_textView.setText(selectedDateRange);
            });

            datePicker.show(requireActivity().getSupportFragmentManager(), "Date");
        });
    }
}
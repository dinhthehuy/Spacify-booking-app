package com.example.hci_prototyp_ws23.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.hci_prototyp_ws23.Models.User;
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
    User user;
    String destination;
    int roomNumber;
    int adultNumber;
    int childrenNumber;
    String startDateString;
    String endDateString;

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
        user = SearchArgs.fromBundle(getArguments()).getUserArg();
        Toast.makeText(getContext(), user.getUsername() + " has arrived !", Toast.LENGTH_SHORT).show();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView.setVisibility(View.GONE);
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        toolbar.setNavigationOnClickListener(v -> NavHostFragment.findNavController(Search.this).popBackStack());
        search_button.setOnClickListener(v -> {
            if(!hasEmptyFields() && !hasInvalidFields()) {
                destination = destinationEditText.getText().toString();
                roomNumber = Integer.parseInt(roomNumberEditText.getText().toString());
                adultNumber = Integer.parseInt(adultNumberEditText.getText().toString());
                childrenNumber = Integer.parseInt(childrenNumberEditText.getText().toString());
                SearchDirections.ActionSearchToSearchResultList action =
                        SearchDirections.actionSearchToSearchResultList(destination, roomNumber, adultNumber, childrenNumber, user, startDateString, endDateString);
                NavHostFragment.findNavController(Search.this).navigate(action);
            }
        });

        date_textView.setOnClickListener(v -> {
            MaterialDatePicker.Builder<Pair<Long, Long>> materialDatePickerBuilder = MaterialDatePicker.Builder.dateRangePicker();
            materialDatePickerBuilder.setTitleText("Select a date range");
            MaterialDatePicker<Pair<Long, Long>> datePicker = materialDatePickerBuilder.build();
            datePicker.addOnPositiveButtonClickListener(selection -> {
                Long startDate = selection.first;
                Long endDate = selection.second;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                startDateString = sdf.format(new Date(startDate));
                endDateString = sdf.format(new Date(endDate));
                String selectedDateRange = startDateString + " - " + endDateString;
                date_textView.setText(selectedDateRange);
            });

            datePicker.show(requireActivity().getSupportFragmentManager(), "Date");
        });
    }

    public boolean hasEmptyFields() {
        if(destinationEditText.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Destination field is empty", Toast.LENGTH_SHORT).show();
            return true;
        }

        if(date_textView.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Date field is empty", Toast.LENGTH_SHORT).show();
            return true;
        }

        if(roomNumberEditText.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Room field is empty", Toast.LENGTH_SHORT).show();
            return true;
        }

        if(adultNumberEditText.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Adult field is empty", Toast.LENGTH_SHORT).show();
            return true;
        }

        if(childrenNumberEditText.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Children field is empty", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    public boolean hasInvalidFields() {
        if(Integer.parseInt(roomNumberEditText.getText().toString()) == 0) {
            Toast.makeText(getContext(), "Invalid room value", Toast.LENGTH_SHORT).show();
            return true;
        }

        if(Integer.parseInt(adultNumberEditText.getText().toString()) == 0) {
            Toast.makeText(getContext(), "Invalid room value", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
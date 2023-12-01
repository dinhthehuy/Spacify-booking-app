package com.example.hci_prototyp_ws23.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.hci_prototyp_ws23.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Homepage extends Fragment {
    View view;
    BottomNavigationView bottomNavigationView;
    Button search_button;
    TextView date_textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_homepage, container, false);
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_bar);
        search_button = view.findViewById(R.id.search_btn);
        date_textView = view.findViewById(R.id.date_edt);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView.setVisibility(View.VISIBLE);
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        search_button.setOnClickListener(v -> NavHostFragment.findNavController(Homepage.this).navigate(R.id.action_homepage_to_searchResultList));
        
        date_textView.setOnClickListener(v -> {
//            final Calendar c = Calendar.getInstance();
//            mYear = c.get(Calendar.YEAR);
//            mMonth = c.get(Calendar.MONTH);
//            mDay = c.get(Calendar.DAY_OF_MONTH);

//            DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(),
//                    (view1, year, monthOfYear, dayOfMonth) -> date_editText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year), mYear, mMonth, mDay);
//            datePickerDialog.show();
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
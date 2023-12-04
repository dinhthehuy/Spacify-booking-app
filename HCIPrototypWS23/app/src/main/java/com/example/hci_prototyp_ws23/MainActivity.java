package com.example.hci_prototyp_ws23;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hci_prototyp_ws23.Fragments.Homepage;
import com.example.hci_prototyp_ws23.Fragments.SavedList;
import com.example.hci_prototyp_ws23.Fragments.UserProfile;
import com.example.hci_prototyp_ws23.Fragments.UserBookings;
import com.example.hci_prototyp_ws23.Models.Address;
import com.example.hci_prototyp_ws23.Models.Hotel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Homepage homepage = new Homepage();
    UserProfile userProfile = new UserProfile();
    SavedList savedList = new SavedList();
    UserBookings userBookings = new UserBookings();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int menuItemId = item.getItemId();
            //navigateFromMenuItem(homepage);
            if (menuItemId == R.id.user_profile_item) {
                navigateFromMenuItem(userProfile);
                return true;
            } else if(menuItemId == R.id.home_item) {
                navigateFromMenuItem(homepage);
                return true;
            } else if(menuItemId == R.id.saved_item) {
                navigateFromMenuItem(savedList);
                return true;
            } else if(menuItemId == R.id.user_bookings_item) {
                navigateFromMenuItem(userBookings);
                return true;
            }
            return true;
        });
        bottomNavigationView.setOnItemReselectedListener(item -> {});
    }

    private void navigateFromMenuItem(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }
}
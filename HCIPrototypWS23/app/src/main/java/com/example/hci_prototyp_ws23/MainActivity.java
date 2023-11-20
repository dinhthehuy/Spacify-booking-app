package com.example.hci_prototyp_ws23;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.hci_prototyp_ws23.Fragments.Homepage;
import com.example.hci_prototyp_ws23.Fragments.UserProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Homepage homepage = new Homepage();
    UserProfile userProfile = new UserProfile();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int menuItemId = item.getItemId();
            navigateFromMenuItem(homepage);
            if (menuItemId == R.id.user_profile_item) {
                navigateFromMenuItem(userProfile);
                return true;
            } else if(menuItemId == R.id.homepage) {
                navigateFromMenuItem(homepage);
                return true;
            } else if(menuItemId == R.id.favorite_item) {
                return true;
            } else if(menuItemId == R.id.booked_item) {
                return true;
            }
            return true;
        });
    }

    private void navigateFromMenuItem(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }
}
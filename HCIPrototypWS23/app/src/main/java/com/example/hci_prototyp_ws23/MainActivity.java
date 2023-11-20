package com.example.hci_prototyp_ws23;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.hci_prototyp_ws23.Fragments.Homepage;
import com.example.hci_prototyp_ws23.Fragments.UserProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int menuItemId = item.getItemId();
            Fragment fragment;

            if(menuItemId == R.id.user_profile_item) {
                fragment = new UserProfile();
                navigateFromMenuItem(fragment);
                return true;
            } else if(menuItemId == R.id.homepage) {
                fragment = new Homepage();
                navigateFromMenuItem(fragment);
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
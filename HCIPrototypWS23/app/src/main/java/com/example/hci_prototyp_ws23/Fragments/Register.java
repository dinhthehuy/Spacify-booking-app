package com.example.hci_prototyp_ws23.Fragments;

import android.database.sqlite.SQLiteDatabase;
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
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.hci_prototyp_ws23.DatabaseHelper;
import com.example.hci_prototyp_ws23.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends Fragment {
    View view;
    Button registerButton;
    BottomNavigationView bottomNavigationView;
    EditText registerEmailEditText, registerPasswordEditText;
    TextView loginNowTextView;
    FirebaseAuth mAuth;
    DatabaseHelper databaseHelper;
    SQLiteDatabase sqLiteDatabase;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_register, container, false);
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_bar);
        mAuth = FirebaseAuth.getInstance();
        registerEmailEditText = view.findViewById(R.id.registerEmail_et);
        registerPasswordEditText = view.findViewById(R.id.registerPassword_et);
        loginNowTextView = view.findViewById(R.id.loginNow_tv);
        registerButton = view.findViewById(R.id.register_btn);
        databaseHelper = DatabaseHelper.getInstance(getContext());
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            NavHostFragment.findNavController(Register.this).navigate(R.id.action_register_to_logIn);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView.setVisibility(View.GONE);
        registerButton.setOnClickListener(v -> {
            final String email = String.valueOf(registerEmailEditText.getText());
            final String password = String.valueOf(registerPasswordEditText.getText());
            if(email.isEmpty()) {
                Toast.makeText(getContext(), "Enter your email", Toast.LENGTH_SHORT).show();
                return;
            }

            if(password.isEmpty()) {
                Toast.makeText(getContext(), "Enter your password", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            if(databaseHelper != null) {
//                                User testUser = new User("dinhthehuy", "Dinh", "The Huy", email, "123456", new Address("Germany", "Darmstadt", "Street", 13),  new Date(100), User.Gender.MALE);
//                                long x = databaseHelper.addUser(testUser, sqLiteDatabase);
//                                Toast.makeText(getContext(), "New Account created ", Toast.LENGTH_SHORT).show();
                                NavHostFragment.findNavController(Register.this).navigate(R.id.action_register_to_logIn);
                            } else {
                                Toast.makeText(getContext(), "Error occurred. Please try again later", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getContext(), "Email already used.", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
        loginNowTextView.setOnClickListener(v -> NavHostFragment.findNavController(Register.this).navigate(R.id.action_register_to_logIn));
    }
}
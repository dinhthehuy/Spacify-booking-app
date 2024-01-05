package com.example.hci_prototyp_ws23;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.hci_prototyp_ws23.Models.User;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String HOTEL_TABLE = "HOTEL";
    public static final String USER_TABLE = "USER";
    public static final String ADDRESS_TABLE = "ADDRESS";
    public static final String BOOKING_TABLE = "BOOKING";
    public static final String USERNAME = "USERNAME";
    public static final String FIRSTNAME = "FIRSTNAME";
    public static final String LASTNAME = "LASTNAME";
    public static final String EMAIL = "EMAIL";
    public static DatabaseHelper instance;

    public static synchronized DatabaseHelper getInstance(Context context) {
        if(instance == null) {
            return new DatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }
    public DatabaseHelper(@Nullable Context context) {
        super(context, "BookingApp.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable = "CREATE TABLE " + USER_TABLE + "("
                + USERNAME + " TEXT, "
                + FIRSTNAME + " TEXT, "
                + LASTNAME + " TEXT, "
                + EMAIL + " TEXT PRIMARY KEY"
                + ");";

        db.execSQL(createUserTable);
        System.out.println("NEW TABLE CREATED");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long addUser(User user, SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(USERNAME, user.getUsername());
        cv.put(FIRSTNAME, user.getFirstName());
        cv.put(LASTNAME, user.getLastName());
        cv.put(EMAIL, user.getEmail());

        return db.insert(USER_TABLE, null, cv);
    }
}

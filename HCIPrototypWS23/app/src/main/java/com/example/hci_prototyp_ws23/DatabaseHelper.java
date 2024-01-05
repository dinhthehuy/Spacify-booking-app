package com.example.hci_prototyp_ws23;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.hci_prototyp_ws23.Models.Address;
import com.example.hci_prototyp_ws23.Models.Hotel;
import com.example.hci_prototyp_ws23.Models.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String HOTEL_TABLE = "hotel";
    private static final String HOTEL_NAME_COLUMN = "hotel_name";
    private static final String HOTEL_COUNTRY_COLUMN = "country";
    private static final String HOTEL_CITY_COLUMN = "city";
    private static final String HOTEL_STREET_ADDRESS_COLUMN = "street_address";
    private static final String HOTEL_POSTAL_CODE_COLUMN = "postal_code";
    public static final String USER_TABLE = "user";
    public static final String USERNAME_COLUMN = "username";
    public static final String USER_FIRST_NAME_COLUMN = "first_name";
    public static final String USER_LAST_NAME_COLUMN = "last_name";
    public static final String USER_EMAIL_COLUMN = "email";
    public static final String USER_COUNTRY_COLUMN = "country";
    public static final String USER_CITY_COLUMN = "city";
    public static final String USER_STREET_ADDRESS_COLUMN = "street_address";
    public static final String USER_POSTAL_CODE_COLUMN = "postal_code";
    public static final String USER_PHONE_NUMBER_COLUMN = "phone_number";
    public static final String USER_GENDER_COLUMN = "gender";
    public static final String USER_DATE_OF_BIRTH_COLUMN = "date_of_birth";

    public static final String ADDRESS_TABLE = "address";
    public static final String COUNTRY_COLUMN = "country";
    public static final String CITY_COLUMN = "city";
    public static final String STREET_ADDRESS_COLUMN = "street_address";
    public static final String POSTAL_CODE_COLUMN = "postal_code";
    private static final String HOTEL_DESCRIPTION_COLUMN = "description";
    public static DatabaseHelper instance;
    ArrayList<Address> initialAddresses = new ArrayList<>(Arrays.asList(
            new Address("United States", "New York", "123 Main St", 10001),
            new Address("United States", "California", "325 Serenity Lane", 90210),
            new Address("United States", "New York", "112 Royal Street, Regal City", 10001),
            new Address("United States", "Florida", "500 Enchanted Grove, Mystical Springs", 33123),
            new Address("United States", "Texas", "75 Luminous Boulevard, Radiant City", 75234),
            new Address("United States", "Los Angeles", "200 Snowfall Lane, Alpine Peaks", 80345)
    ));

    ArrayList<Hotel> initialHotels = new ArrayList<>(Arrays.asList(
            new Hotel("Mercure", new Address("United States", "New York", "123 Main St", 10001),""),
            new Hotel("Azure Haven Hotel", new Address("United States", "California", "325 Serenity Lane", 90210),""),
            new Hotel("Crimson Crown Inn", new Address("United States", "New York", "112 Royal Street, Regal City", 10001),""),
            new Hotel("Mystic Oasis Resort", new Address("United States", "Florida", "500 Enchanted Grove, Mystical Springs", 33123),""),
            new Hotel("Radiant Horizon Hotel", new Address("United States", "Texas", "75 Luminous Boulevard, Radiant City", 75234),""),
            new Hotel("Alpine Haven Lodge", new Address("United States", "Los Angeles", "200 Snowfall Lane, Alpine Peaks", 80345),"")
    ));

    ArrayList<User> initialUsers;

    {
        try {
            initialUsers = new ArrayList<>(Collections.singletonList(
                    new User("dinhthehuy", "Dinh", "The Huy", "dinhthehuy51@gmail.com", "123456",
                            new Address("Germany", "Darmstadt", "Street", 13),
                            new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse("2002-11-08"),
                            User.Gender.MALE)
            ));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        if(instance == null) {
            return new DatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }
    public DatabaseHelper(@Nullable Context context) {
        super(context, "HotelApp.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createAddressTable = "CREATE TABLE " + ADDRESS_TABLE + " ("
                + COUNTRY_COLUMN + " TEXT, "
                + CITY_COLUMN + " TEXT, "
                + STREET_ADDRESS_COLUMN + " TEXT, "
                + POSTAL_CODE_COLUMN + " INTEGER, "
                + "PRIMARY KEY (" + COUNTRY_COLUMN + ", " + CITY_COLUMN + ", " + STREET_ADDRESS_COLUMN + ", " + POSTAL_CODE_COLUMN
                + "));";

        String createHotelTable = "CREATE TABLE " + HOTEL_TABLE + " ("
                + HOTEL_NAME_COLUMN + " TEXT, "
                + HOTEL_COUNTRY_COLUMN + " TEXT NOT NULL REFERENCES " + ADDRESS_TABLE + "(" + STREET_ADDRESS_COLUMN + "), "
                + HOTEL_CITY_COLUMN + " TEXT NOT NULL REFERENCES " + ADDRESS_TABLE + "(" + CITY_COLUMN + "), "
                + HOTEL_STREET_ADDRESS_COLUMN + " INTEGER NOT NULL REFERENCES " + ADDRESS_TABLE + "(" + STREET_ADDRESS_COLUMN + "), "
                + HOTEL_POSTAL_CODE_COLUMN + " INTEGER NOT NULL REFERENCES " + ADDRESS_TABLE + "(" + POSTAL_CODE_COLUMN + "), "
                + HOTEL_DESCRIPTION_COLUMN + " TEXT, "
                + "PRIMARY KEY (" + HOTEL_NAME_COLUMN
                + "));";

        String createUserTable = "CREATE TABLE " + USER_TABLE + " ("
                + USERNAME_COLUMN + " TEXT, "
                + USER_FIRST_NAME_COLUMN + " TEXT, "
                + USER_LAST_NAME_COLUMN + " TEXT, "
                + USER_EMAIL_COLUMN + " TEXT, "
                + USER_COUNTRY_COLUMN + " TEXT NOT NULL REFERENCES " + ADDRESS_TABLE + "(" + STREET_ADDRESS_COLUMN + "), "
                + USER_CITY_COLUMN + " TEXT NOT NULL REFERENCES " + ADDRESS_TABLE + "(" + CITY_COLUMN + "), "
                + USER_STREET_ADDRESS_COLUMN + " INTEGER NOT NULL REFERENCES " + ADDRESS_TABLE + "(" + STREET_ADDRESS_COLUMN + "), "
                + USER_POSTAL_CODE_COLUMN + " INTEGER NOT NULL REFERENCES " + ADDRESS_TABLE + "(" + POSTAL_CODE_COLUMN + "), "
                + USER_PHONE_NUMBER_COLUMN + " TEXT, "
                + USER_GENDER_COLUMN + " TEXT, "
                + USER_DATE_OF_BIRTH_COLUMN + " TEXT, "
                + "PRIMARY KEY (" + USERNAME_COLUMN
                + "));";

        db.execSQL(createAddressTable);
        db.execSQL(createHotelTable);
        db.execSQL(createUserTable);
        loadInitialAddress(db);
        loadInitialHotels(db);
        insertUser(db, initialUsers.get(0));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void loadInitialAddress(SQLiteDatabase db) {
        for(int i = 0; i < initialAddresses.size(); i++) {
            ContentValues cv = new ContentValues();
            cv.put(COUNTRY_COLUMN, initialAddresses.get(i).getCountry());
            cv.put(CITY_COLUMN, initialAddresses.get(i).getCity());
            cv.put(STREET_ADDRESS_COLUMN, initialAddresses.get(i).getStreetAddress());
            cv.put(POSTAL_CODE_COLUMN, initialAddresses.get(i).getPostalCode());
            db.insert(ADDRESS_TABLE, null, cv);
        }
    }

    public void loadInitialHotels(SQLiteDatabase db) {
        for(int i = 0; i < initialHotels.size(); i++) {
            ContentValues cv = new ContentValues();
            cv.put(HOTEL_NAME_COLUMN, initialHotels.get(i).getHotelName());
            cv.put(HOTEL_COUNTRY_COLUMN, initialHotels.get(i).getHotelAddress().getCountry());
            cv.put(HOTEL_CITY_COLUMN, initialHotels.get(i).getHotelAddress().getCity());
            cv.put(HOTEL_STREET_ADDRESS_COLUMN, initialHotels.get(i).getHotelAddress().getStreetAddress());
            cv.put(HOTEL_POSTAL_CODE_COLUMN, initialHotels.get(i).getHotelAddress().getPostalCode());
            cv.put(HOTEL_DESCRIPTION_COLUMN, initialHotels.get(i).getDescription());
            db.insert(HOTEL_TABLE, null, cv);
        }
    }

    public void insertUser(SQLiteDatabase db, User user) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        ContentValues cv = new ContentValues();
        cv.put(USERNAME_COLUMN, user.getUsername());
        cv.put(USER_FIRST_NAME_COLUMN, user.getFirstName());
        cv.put(USER_LAST_NAME_COLUMN, user.getLastName());
        cv.put(USER_EMAIL_COLUMN, user.getEmail());
        cv.put(USER_COUNTRY_COLUMN, user.getUserAddress().getCountry());
        cv.put(USER_CITY_COLUMN, user.getUserAddress().getCity());
        cv.put(USER_STREET_ADDRESS_COLUMN, user.getUserAddress().getStreetAddress());
        cv.put(USER_POSTAL_CODE_COLUMN, user.getUserAddress().getPostalCode());
        cv.put(USER_PHONE_NUMBER_COLUMN, user.getPhoneNumber());
        cv.put(USER_GENDER_COLUMN, user.getGender().name());
        cv.put(USER_DATE_OF_BIRTH_COLUMN, sdf.format(user.getDateOfBirth()));
        db.insert(USER_TABLE, null, cv);
    }
}
package com.example.hci_prototyp_ws23;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String HOTEL_TABLE = "hotel";
    private static final String HOTEL_NAME_COLUMN = "hotel_name";
    private static final String HOTEL_COUNTRY_COLUMN = "country";
    private static final String HOTEL_CITY_COLUMN = "city";
    private static final String HOTEL_STREET_ADDRESS_COLUMN = "street_address";
    private static final String HOTEL_POSTAL_CODE_COLUMN = "postal_code";
    private static final String HOTEL_PRICE_PER_NIGHT = "price_per_night";
    private static final String USER_TABLE = "user";
    private static final String USERNAME_COLUMN = "username";
    private static final String USER_FIRST_NAME_COLUMN = "first_name";
    private static final String USER_LAST_NAME_COLUMN = "last_name";
    private static final String USER_EMAIL_COLUMN = "email";
    private static final String USER_COUNTRY_COLUMN = "country";
    private static final String USER_CITY_COLUMN = "city";
    private static final String USER_STREET_ADDRESS_COLUMN = "street_address";
    private static final String USER_POSTAL_CODE_COLUMN = "postal_code";
    private static final String USER_PHONE_NUMBER_COLUMN = "phone_number";
    private static final String USER_GENDER_COLUMN = "gender";
    private static final String USER_DATE_OF_BIRTH_COLUMN = "date_of_birth";
    private static final String ADDRESS_TABLE = "address";
    private static final String COUNTRY_COLUMN = "country";
    private static final String CITY_COLUMN = "city";
    private static final String STREET_ADDRESS_COLUMN = "street_address";
    private static final String POSTAL_CODE_COLUMN = "postal_code";
    private static final String HOTEL_DESCRIPTION_COLUMN = "description";
    private static final String SERVICE_TABLE = "service";
    private static final String SERVICE_NAME_COLUMN = "name";
    private static final String SERVICE_HOTEL_NAME_COLUMN = "hotel_name";
    private static final String BOOKING_TABLE = "booking";
    private static final String BOOKING_USERNAME_COLUMN = "username";
    private static final String BOOKING_HOTEL_NAME_COLUMN = "hotel_name";
    private static final String BOOKING_CHECK_IN_DATE_COLUMN = "check_in_date";
    private static final String BOOKING_CHECK_OUT_DATE_COLUMN = "check_out_date";
    private static final String BOOKING_ADULT_NUMBER_COLUMN = "adult_number";
    private static final String BOOKING_CHILDREN_NUMBER_COLUMN = "children_number";
    private static final String BOOKING_TOTAL_PRICE_COLUMN = "total_price";
    private static final String BOOKING_PAYMENT_METHOD_COLUMN = "payment_method";
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
            new Hotel("Mercure", new Address("United States", "New York", "123 Main St", 10001),"", 90),
            new Hotel("Azure Haven Hotel", new Address("United States", "California", "325 Serenity Lane", 90210),"", 100),
            new Hotel("Crimson Crown Inn", new Address("United States", "New York", "112 Royal Street, Regal City", 10001),"", 85),
            new Hotel("Mystic Oasis Resort", new Address("United States", "Florida", "500 Enchanted Grove, Mystical Springs", 33123),"", 90),
            new Hotel("Radiant Horizon Hotel", new Address("United States", "Texas", "75 Luminous Boulevard, Radiant City", 75234),"", 95),
            new Hotel("Alpine Haven Lodge", new Address("United States", "Los Angeles", "200 Snowfall Lane, Alpine Peaks", 80345),"", 110)
    ));

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
                + HOTEL_DESCRIPTION_COLUMN + " TEXT NOT NULL, "
                + HOTEL_PRICE_PER_NIGHT + " FLOAT NOT NULL, "
                + "PRIMARY KEY (" + HOTEL_NAME_COLUMN
                + "));";

        String createUserTable = "CREATE TABLE " + USER_TABLE + " ("
                + USERNAME_COLUMN + " TEXT, "
                + USER_FIRST_NAME_COLUMN + " TEXT NOT NULL, "
                + USER_LAST_NAME_COLUMN + " TEXT NOT NULL, "
                + USER_EMAIL_COLUMN + " TEXT NOT NULL, "
                + USER_COUNTRY_COLUMN + " TEXT NOT NULL REFERENCES " + ADDRESS_TABLE + "(" + STREET_ADDRESS_COLUMN + "), "
                + USER_CITY_COLUMN + " TEXT NOT NULL REFERENCES " + ADDRESS_TABLE + "(" + CITY_COLUMN + "), "
                + USER_STREET_ADDRESS_COLUMN + " TEXT NOT NULL REFERENCES " + ADDRESS_TABLE + "(" + STREET_ADDRESS_COLUMN + "), "
                + USER_POSTAL_CODE_COLUMN + " INTEGER NOT NULL REFERENCES " + ADDRESS_TABLE + "(" + POSTAL_CODE_COLUMN + "), "
                + USER_PHONE_NUMBER_COLUMN + " TEXT NOT NULL, "
                + USER_GENDER_COLUMN + " TEXT NOT NULL, "
                + USER_DATE_OF_BIRTH_COLUMN + " DATE NOT NULL, "
                + "PRIMARY KEY (" + USERNAME_COLUMN
                + "));";

        String createBookingTable = "CREATE TABLE " + BOOKING_TABLE + " ("
                + BOOKING_USERNAME_COLUMN + " TEXT REFERENCES " + USER_TABLE + "(" + USERNAME_COLUMN + "), "
                + BOOKING_HOTEL_NAME_COLUMN + " TEXT REFERENCES " + HOTEL_TABLE + "(" + HOTEL_NAME_COLUMN + "), "
                + BOOKING_CHECK_IN_DATE_COLUMN + " DATE, "
                + BOOKING_CHECK_OUT_DATE_COLUMN + " DATE, "
                + BOOKING_ADULT_NUMBER_COLUMN + " INTEGER NOT NULL, "
                + BOOKING_CHILDREN_NUMBER_COLUMN + " INTEGER NOT NULL, "
                + BOOKING_TOTAL_PRICE_COLUMN + " FLOAT NOT NULL, "
                + BOOKING_PAYMENT_METHOD_COLUMN + " TEXT NOT NULL, "
                + "PRIMARY KEY (" + BOOKING_USERNAME_COLUMN + ", " + BOOKING_HOTEL_NAME_COLUMN + ", " + BOOKING_CHECK_IN_DATE_COLUMN + ", " + BOOKING_CHECK_OUT_DATE_COLUMN
                + "));";

        String createServiceTable = "CREATE TABLE " + SERVICE_TABLE + " ("
                + SERVICE_HOTEL_NAME_COLUMN + " TEXT REFERENCES " + HOTEL_TABLE + "(" + HOTEL_NAME_COLUMN + "), "
                + SERVICE_NAME_COLUMN + " TEXT NOT NULL, "
                + "PRIMARY KEY (" + SERVICE_HOTEL_NAME_COLUMN
                + "));";

        db.execSQL(createAddressTable);
        db.execSQL(createHotelTable);
        db.execSQL(createUserTable);
        db.execSQL(createServiceTable);
        db.execSQL(createBookingTable);
        loadInitialAddress(db);
        loadInitialHotels(db);
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
            cv.put(HOTEL_PRICE_PER_NIGHT, initialHotels.get(i).getPricePerNight());
            db.insert(HOTEL_TABLE, null, cv);
        }
    }

    public void insertUser(User user, SQLiteDatabase db) {
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

    public User readUserByEmail(String email) {
        User user;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String queryUser = "SELECT * FROM " + USER_TABLE + " WHERE " + USER_EMAIL_COLUMN + "=" + "'"+email+"'" + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryUser, null);
        if(cursor.moveToFirst()) {
            String readUsername = cursor.getString(0);
            String readFirstName = cursor.getString(1);
            String readLastName = cursor.getString(2);
            String readEmail = cursor.getString(3);
            String readCountry = cursor.getString(4);
            String readCity = cursor.getString(5);
            String readAddress = cursor.getString(6);
            int readPostalCode = cursor.getInt(7);
            String readPhoneNumber = cursor.getString(8);
            String readGender = cursor.getString(9);
            String readDateOfBirth = cursor.getString(10);
            try {
                user = new User(readUsername, readFirstName, readLastName, readEmail, readPhoneNumber, new Address(readCountry, readCity, readAddress, readPostalCode), sdf.parse(readDateOfBirth), User.Gender.valueOf(readGender));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
        cursor.close();
        db.close();
        return user;
    }

    public void updateUser(User user) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME_COLUMN, user.getUsername());
        values.put(USER_FIRST_NAME_COLUMN, user.getFirstName());
        values.put(USER_LAST_NAME_COLUMN, user.getLastName());
        values.put(USER_EMAIL_COLUMN, user.getEmail());
        values.put(USER_COUNTRY_COLUMN, user.getUserAddress().getCountry());
        values.put(USER_CITY_COLUMN, user.getUserAddress().getCity());
        values.put(USER_STREET_ADDRESS_COLUMN, user.getUserAddress().getStreetAddress());
        values.put(USER_POSTAL_CODE_COLUMN, String.valueOf(user.getUserAddress().getPostalCode()));
        values.put(USER_PHONE_NUMBER_COLUMN, user.getPhoneNumber());
        values.put(USER_GENDER_COLUMN, user.getGender().name());
        values.put(USER_DATE_OF_BIRTH_COLUMN, sdf.format(user.getDateOfBirth()));
        String whereClause = USER_EMAIL_COLUMN + "= ? ";
        String[] whereArgs = {user.getEmail()};
        db.update(USER_TABLE, values, whereClause, whereArgs);
    }
}

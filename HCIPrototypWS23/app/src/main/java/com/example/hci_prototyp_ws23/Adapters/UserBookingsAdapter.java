package com.example.hci_prototyp_ws23.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hci_prototyp_ws23.Models.Booking;
import com.example.hci_prototyp_ws23.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class UserBookingsAdapter extends RecyclerView.Adapter<UserBookingsAdapter.UserBookingAdapterViewHolder> {
    private Context context;
    private final List<Booking> bookingList;
    public UserBookingsAdapter(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }
    @NonNull
    @Override
    public UserBookingAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_bookings_item, parent, false);
        context = parent.getContext();
        return new UserBookingAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserBookingAdapterViewHolder holder, int position) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        holder.nameTextView.setText(bookingList.get(position).getHotel().getHotelName());
        String date = "Check-in: " + sdf.format(bookingList.get(position).getCheckInDate()) + "\n"
                + "Check-out: " + sdf.format(bookingList.get(position).getCheckOutDate());
        holder.dateTextView.setText(date);
        holder.imageView.setImageResource(context.getResources().getIdentifier(bookingList.get(position).getHotel().getImageURL(), "drawable", context.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return bookingList.size();
    }

    public static class UserBookingAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView, dateTextView;
        public UserBookingAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.userBookings_iv);
            nameTextView = itemView.findViewById(R.id.userBookingsHotelName_tv);
            dateTextView = itemView.findViewById(R.id.userBookingsHotelDate_tv);
        }
    }
}

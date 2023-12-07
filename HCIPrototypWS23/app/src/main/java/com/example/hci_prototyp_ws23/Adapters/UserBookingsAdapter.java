package com.example.hci_prototyp_ws23.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hci_prototyp_ws23.Models.Hotel;
import com.example.hci_prototyp_ws23.R;

import java.util.List;

public class UserBookingsAdapter extends RecyclerView.Adapter<UserBookingsAdapter.UserBookingAdapterViewHolder> {
    private final List<Hotel> hotelList;
    public UserBookingsAdapter(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }
    @NonNull
    @Override
    public UserBookingAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_bookings_item, parent, false);
        return new UserBookingAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserBookingAdapterViewHolder holder, int position) {
        holder.nameTextView.setText(hotelList.get(position).getHotelName());
        String date = "20-21 Dez 2021";
        holder.dateTextView.setText(date);
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
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

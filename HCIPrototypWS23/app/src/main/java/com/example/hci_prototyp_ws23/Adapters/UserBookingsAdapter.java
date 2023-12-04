package com.example.hci_prototyp_ws23.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hci_prototyp_ws23.Models.Hotel;
import com.example.hci_prototyp_ws23.R;

import java.util.List;

public class UserBookingsAdapter extends RecyclerView.Adapter<UserBookingsAdapter.UserBookingAdapterViewHolder> {
    List<Hotel> hotelList;
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
        // Implementation needed
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class UserBookingAdapterViewHolder extends RecyclerView.ViewHolder {
        // Implementation needed
        public UserBookingAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            // Implementation needed
        }
    }
}

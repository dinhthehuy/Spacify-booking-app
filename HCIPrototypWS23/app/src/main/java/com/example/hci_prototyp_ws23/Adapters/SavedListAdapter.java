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

public class SavedListAdapter extends RecyclerView.Adapter<SavedListAdapter.SavedListAdapterViewHolder> {
    private List<Hotel> hotelList;
    public SavedListAdapter(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }
    @NonNull
    @Override
    public SavedListAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_list_item, parent, false);
        return new SavedListAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SavedListAdapterViewHolder holder, int position) {
        holder.nameView.setText(hotelList.get(position).getHotelName());
        String Address = hotelList.get(position).getHotelAddress().getCountry() + hotelList.get(position).getHotelAddress().getCity() +  hotelList.get(position).getHotelAddress().getStreetAddress() + hotelList.get(position).getHotelAddress().getPostalCode();
        holder.addressView.setText(Address);
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    public static class SavedListAdapterViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView nameView, addressView;
        public SavedListAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.savedList_iv);
            nameView = itemView.findViewById(R.id.savedListHotelName_tv);
            addressView = itemView.findViewById(R.id.savedListHotelAddress_tv);
        }
    }
}

package com.example.hci_prototyp_ws23.Adapters;

import android.media.tv.AdRequest;
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

public class SearchResultListAdapter extends RecyclerView.Adapter<SearchResultListAdapter.SearchResultListAdapterViewHolder> {
    private List<Hotel> hotelList;
    public SearchResultListAdapter(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }
    @NonNull
    @Override
    public SearchResultListAdapter.SearchResultListAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_list_item, parent, false);
        return new SearchResultListAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchResultListAdapter.SearchResultListAdapterViewHolder holder, int position) {
        holder.nameView.setText(hotelList.get(position).getHotelName());
        String Address = hotelList.get(position).getHotelAddress().getCountry() + hotelList.get(position).getHotelAddress().getCity() +  hotelList.get(position).getHotelAddress().getStreetAddress() + hotelList.get(position).getHotelAddress().getPostalCode();
        holder.adressView.setText(Address);
        //set Image Resource for the hotel
        //holder.imageView.setImageResource();

    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    public static class SearchResultListAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameView, adressView;

        public SearchResultListAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.resultlistimageview);
            nameView = itemView.findViewById(R.id.hotelname);
            adressView = itemView.findViewById(R.id.hoteladdress);
            }
        }
    }



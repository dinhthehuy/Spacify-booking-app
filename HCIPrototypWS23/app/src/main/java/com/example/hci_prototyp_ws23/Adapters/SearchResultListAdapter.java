package com.example.hci_prototyp_ws23.Adapters;

import android.annotation.SuppressLint;
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
    private final List<Hotel> hotelList;
    private onClickListener onClickListener;
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
    public void onBindViewHolder(@NonNull SearchResultListAdapter.SearchResultListAdapterViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Hotel hotel = hotelList.get(position);
        holder.nameView.setText(hotelList.get(position).getHotelName());
        String Address =  hotelList.get(position).getHotelAddress().getStreetAddress() + " " + hotelList.get(position).getHotelAddress().getCity() +  "\n" + hotelList.get(position).getHotelAddress().getPostalCode() + ", " + hotelList.get(position).getHotelAddress().getCountry();
        holder.addressView.setText(Address);
        holder.itemView.setOnClickListener(v -> {
            if(onClickListener != null) {
                onClickListener.onClick(position, hotel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }
    public void setOnClickListener(onClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface onClickListener {
        void onClick(int position, Hotel hotel);
    }

    public static class SearchResultListAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameView, addressView;
        public SearchResultListAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.searchResultList_iv);
            nameView = itemView.findViewById(R.id.searchResultListHotelName_tv);
            addressView = itemView.findViewById(R.id.searchResultListHotelAddress_tv);
            }
        }
    }



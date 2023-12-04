package com.example.hci_prototyp_ws23.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        // Implementation needed
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class SearchResultListAdapterViewHolder extends RecyclerView.ViewHolder {
        // Implementation needed

        public SearchResultListAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            // Implementation needed
        }
    }

}

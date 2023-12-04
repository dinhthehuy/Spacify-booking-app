package com.example.hci_prototyp_ws23.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        // Implementation needed
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class SavedListAdapterViewHolder extends RecyclerView.ViewHolder{
        // Implementation needed
        public SavedListAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            // Implementation needed
        }
    }
}

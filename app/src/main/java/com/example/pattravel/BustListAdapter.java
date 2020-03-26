package com.example.pattravel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BustListAdapter extends RecyclerView.Adapter<BustListAdapter.BusViewHolder> {

    private List<Bus> busList;

    static class BusViewHolder extends RecyclerView.ViewHolder {
        TextView townOne;
        TextView townTwo;
        TextView transport;
        TextView dollars;
        BusViewHolder(View view) {
            super(view);
            townOne = view.findViewById(R.id.toList);
            townTwo = view.findViewById(R.id.twonTwoList);
            transport = view.findViewById(R.id.fromList);
            dollars = view.findViewById(R.id.dollars);
        }
    }
    public BustListAdapter(List<Bus> busList) {
        this.busList = busList;
    }
    @NonNull
    @Override
    public BusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bus_list_items, parent, false);
        return new BusViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(BusViewHolder holder, int position) {
        Bus bus = busList.get(position);
        holder.townOne.setText(bus.getTownOne());
        holder.townTwo.setText(bus.getTownTwo());
        holder.transport.setText(bus.getTransport());
        holder.dollars.setText(bus.getDollar());
    }
    @Override
    public int getItemCount() {
        return busList.size();
    }

}

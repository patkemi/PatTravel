package com.example.pattravel;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SeatsAdapter extends RecyclerView.Adapter<SeatsAdapter.SeatsViewHolder> {

    private List<Seats> seatsList;

    static class SeatsViewHolder extends RecyclerView.ViewHolder {
        TextView seatsView;
        CardView cardView;
        SeatsViewHolder(View view) {
            super(view);
            seatsView = view.findViewById(R.id.seat_no);
            cardView = view.findViewById(R.id.cardView);
        }
    }
    public SeatsAdapter(List<Seats> seatsList) {
        this.seatsList = seatsList;
    }
    @NonNull
    @Override
    public SeatsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.seats_lists, parent, false);
        return new SeatsViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(SeatsViewHolder holder, int position) {
        Seats seat = seatsList.get(position);
        holder.seatsView.setText(seat.getSeats());

        holder.seatsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.seatsView.setTextColor(Color.parseColor("#FFDA0347"));
                holder.cardView.setCardBackgroundColor(Color.parseColor("#FFFB8AAE"));
            }
        });


    }
    @Override
    public int getItemCount() {
        return seatsList.size();
    }

}

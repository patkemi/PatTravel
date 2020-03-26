package com.example.pattravel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Seats> seatsList;
    private SeatsAdapter mAdapter;
    RecyclerView recyclerView;
    ImageView imageViewDate;
    DatePickerDialog picker;
    TextView textViewDateHolder;
    ImageButton imageButtonFindBus;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seatsList = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        prepareSeatsData();
        mAdapter = new SeatsAdapter(seatsList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        // Date picking
        imageViewDate = (ImageView) findViewById(R.id.datePicking);
        textViewDateHolder = (TextView) findViewById(R.id.textViewShowDate);
        imageButtonFindBus = (ImageButton) findViewById(R.id.lastbutton);

        imageViewDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                textViewDateHolder.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();

            }
        });

        imageButtonFindBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BusListActivity.class));
            }
        });

    }

    private void prepareSeatsData() {

        Seats seat = new Seats("1 Seats");
        seatsList.add(seat);
        seat = new Seats("2 Seats");
        seatsList.add(seat);
        seat = new Seats("3 Seats");
        seatsList.add(seat);
        seat = new Seats("4 Seats");
        seatsList.add(seat);
        seat = new Seats("5 Seats");
        seatsList.add(seat);
        seat = new Seats("6 Seats");
        seatsList.add(seat);
        seat = new Seats("7 Seats");
        seatsList.add(seat);
        seat = new Seats("8 Seats");
        seatsList.add(seat);
        seat = new Seats("9 Seats");
        seatsList.add(seat);
        seat = new Seats("10 Seats");
        seatsList.add(seat);

    }
}

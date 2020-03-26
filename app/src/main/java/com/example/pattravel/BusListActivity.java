package com.example.pattravel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class BusListActivity extends AppCompatActivity {

    private List<Bus> busList;
    private BustListAdapter mAdapter;
    RecyclerView recyclerViewBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);

        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        assert toolbar != null;
        toolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        busList = new ArrayList<>();
        recyclerViewBus = (RecyclerView)findViewById(R.id.recyclerViewBus);
        prepareBusData();
        mAdapter = new BustListAdapter(busList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewBus.setLayoutManager(mLayoutManager);
        recyclerViewBus.setHasFixedSize(true);
        recyclerViewBus.setItemAnimator(new DefaultItemAnimator());
        recyclerViewBus.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();


    }

    private void prepareBusData() {

        Bus bus = new Bus("8:00 Chennai", "7:30 Banglore", "Kallada Transport","$20");
        busList.add(bus);
        bus = new Bus("9:00 Caimbatore", "7:30 Banglore", "KPN Transport","$18");
        busList.add(bus);
        bus = new Bus("8:00 Chennai", "7:00 Karur", "SRM Transport","$23");
        busList.add(bus);
        bus = new Bus("8:00 Nevada", "10:30 Vegas", "SRM Transport","$50");
        busList.add(bus);

    }
}

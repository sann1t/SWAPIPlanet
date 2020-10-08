package com.example.swapiapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.swapiapi.adapters.recyclerview.StartActivityAdapter;

public class StartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StartActivityAdapter startActivityAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        recyclerView = findViewById(R.id.start_activity_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        startActivityAdapter = new StartActivityAdapter(this);
        recyclerView.setAdapter(startActivityAdapter);
    }

}
package com.example.swapiapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;

import com.example.swapiapi.adapters.recyclerview.StartActivityAdapter;
import com.example.swapiapi.categoryActivity.peoples.PeopleActivity;
import com.example.swapiapi.categoryActivity.planets.PlanetActivity;
import com.example.swapiapi.categoryActivity.species.SpecieActivity;
import com.example.swapiapi.categoryActivity.starships.StarShipActivity;
import com.example.swapiapi.categoryActivity.vehicles.VehicleActivity;

public class StartActivity extends AppCompatActivity implements CallBackStartNewActivity {

    private RecyclerView recyclerView;
    private StartActivityAdapter startActivityAdapter;
    private ImageView imageView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initializeRecyclerView();
        initializeToolbar();
    }

    private void initializeRecyclerView() {
        recyclerView = findViewById(R.id.start_activity_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        startActivityAdapter = new StartActivityAdapter(this, this);
        recyclerView.setAdapter(startActivityAdapter);
    }

    @Override
    public void startNewActivity(String nameCategory) {
        Intent intent;
        switch(nameCategory) {
            case "vehicles" :
                intent = new Intent(this, VehicleActivity.class);
                break;
            case "peoples" :
                intent = new Intent(this, PeopleActivity.class);
                break;
            case "starShips" :
                intent = new Intent(this, StarShipActivity.class);
                break;
            case "planets" :
                intent = new Intent(this, PlanetActivity.class);
                break;
            case "species" :
                intent = new Intent(this, SpecieActivity.class);
                break;
            default: intent = null;
        }
        this.startActivity(intent);
    }

    private void initializeToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

}
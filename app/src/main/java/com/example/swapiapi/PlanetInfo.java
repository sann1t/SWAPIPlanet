package com.example.swapiapi;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.swapiapi.adapters.MyAdapter;
import com.example.swapiapi.models.Planet;
import com.example.swapiapi.models.PlanetList;

public class PlanetInfo extends AppCompatActivity {

    private Toolbar toolbar;
    private Planet planet;
    private LinearLayout linearLayout;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_info);
        planet = (Planet) getIntent().getSerializableExtra("Planet");
        linearLayout = findViewById(R.id.parametersPlanet);

        initializeProgressBar();
        initializeToolBar();
        initializeInfoPlanet();
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

    private void initializeToolBar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(planet.getName());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void createNewTextView(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setTextColor(Color.BLACK);
        textView.setGravity(Gravity.START);
        textView.setTextSize(16);

        linearLayout.addView(textView);
    }
    private void initializeInfoPlanet() {
        createNewTextView("Rotation period: " + planet.getRotationPeriod());
        createNewTextView("Orbital period: " + planet.getOrbitalPeriod());
        createNewTextView("Diameter: " + planet.getDiameter());
        createNewTextView("Climate: " + planet.getClimate());
        createNewTextView("Gravity: " + planet.getGravity());
        createNewTextView("Terrain: " + planet.getTerrain());
        createNewTextView("Surface water: " + planet.getSurfaceWater());
        createNewTextView("Population: " + planet.getPopulation());

    }

    private void initializeProgressBar() {
        progressBar = findViewById(R.id.progress_bar_planet_info);
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("Planet", planet);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        planet = (Planet) savedInstanceState.getSerializable("Planet");
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }
}

package com.example.swapiapi.categoryActivity.planets;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.models.peoples.People;
import com.example.swapiapi.models.planets.Planet;

public class PlanetActivityInfo extends AppCompatActivity {

    private Bundle bundle;
    private Planet planet;
    private Toolbar toolbar;
    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    private String[] planetInfo;
    private LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_info);
        initializeData();

        initializeInfo();
        initializeToolbar();
    }

    private void initializeToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(planet.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    private void initializeInfo() {
        linearLayout = findViewById(R.id.infoCategory);

        for(int i = 0; i < planetInfo.length; i++) {
            TextView info = new TextView(this);
            info.setText(planetInfo[i]);
            info.setGravity(Gravity.START);
            info.setTextSize(16);
            info.setTextColor(Color.BLACK);
            linearLayout.addView(info, params);
        }
    }
    private void initializeData() {
        bundle = getIntent().getExtras();
        planet = (Planet) bundle.getSerializable("Planet");
        String[] info = {"name: " + planet.getName(), "rotation period: " + planet.getRotationPeriod(), "orbital period: " + planet.getOrbitalPeriod(),
                "diameter: " + planet.getDiameter(), "climate: " + planet.getClimate(), "gravity: " + planet.getGravity(), "terrain: " + planet.getTerrain(),
                "surface water: " + planet.getSurfaceWater(), "population: " + planet.getPopulation()};
        planetInfo = info;
    }
}

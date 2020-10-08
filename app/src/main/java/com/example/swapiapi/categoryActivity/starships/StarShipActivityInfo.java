package com.example.swapiapi.categoryActivity.starships;

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
import com.example.swapiapi.models.starships.StarShip;

public class StarShipActivityInfo extends AppCompatActivity {

    private Bundle bundle;
    private StarShip starShip;
    private Toolbar toolbar;
    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    private String[] starShipInfo;
    private LinearLayout linearLayout;


    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_info);
        initializeData();

        initializeInfo();
        initializeToolbar();
    }

    private void initializeToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(starShip.getName());
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

        for(int i = 0; i < starShipInfo.length; i++) {
            TextView info = new TextView(this);
            info.setText(starShipInfo[i]);
            info.setGravity(Gravity.START);
            info.setTextSize(16);
            info.setTextColor(Color.BLACK);
            linearLayout.addView(info, params);
        }
    }
    private void initializeData() {
        bundle = getIntent().getExtras();
        starShip = (StarShip) bundle.getSerializable("StarShip");
        String[] info = {"name: " + starShip.getName(), "MGLT: " + starShip.getMGLT(), "cargo capacity: " + starShip.getCargo_capacity(),
                "consumables: " + starShip.getConsumables(), "cost in credits: " + starShip.getCost_in_credits(), "crew: " + starShip.getCrew(),
                "hyperdrive rating: " + starShip.getHyperdrive_rating(), "length: " + starShip.getLength(), "manufacturer: " + starShip.getManufacturer(),
                "max atmosphering speed: " + starShip.getMax_atmosphering_speed(), "model: " + starShip.getModel(), "passengers: " + starShip.getPassengers()};

        starShipInfo = info;
    }
}

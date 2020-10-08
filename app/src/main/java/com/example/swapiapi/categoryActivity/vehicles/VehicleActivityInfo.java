package com.example.swapiapi.categoryActivity.vehicles;

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
import com.example.swapiapi.models.vehicles.Vehicle;

public class VehicleActivityInfo extends AppCompatActivity {

    private Bundle bundle;
    private Vehicle vehicle;
    private Toolbar toolbar;
    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    private String[] vehicleInfo;
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
        getSupportActionBar().setTitle(vehicle.getName());
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

        for(int i = 0; i < vehicleInfo.length; i++) {
            TextView info = new TextView(this);
            info.setText(vehicleInfo[i]);
            info.setGravity(Gravity.START);
            info.setTextSize(16);
            info.setTextColor(Color.BLACK);
            linearLayout.addView(info, params);
        }
    }
    private void initializeData() {
        bundle = getIntent().getExtras();
        vehicle = (Vehicle) bundle.getSerializable("Vehicle");
        String[] info = {"name: " + vehicle.getName(), "cargo capacity: " + vehicle.getCargo_capacity(), "consumables: " + vehicle.getConsumables(),
                "cost in credits: " + vehicle.getCost_in_credits(), "crew: " + vehicle.getCrew(), "length: " + vehicle.getLength(), "manufacturer: " + vehicle.getManufacturer(),
                "max atmosphering speed: " + vehicle.getMax_atmosphering_speed(), "model: " + vehicle.getModel(), "passengers: " + vehicle.getPassengers(), "vehicle class: " + vehicle.getVehicle_class()};
        vehicleInfo = info;
    }
}

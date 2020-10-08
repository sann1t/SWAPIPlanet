package com.example.swapiapi.categoryActivity.vehicles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.example.swapiapi.R;
import com.example.swapiapi.adapters.recyclerview.StarShipActivityAdapter;
import com.example.swapiapi.adapters.recyclerview.VehicleActivityAdapter;
import com.example.swapiapi.categoryActivity.starships.StarShipActivity;
import com.example.swapiapi.models.starships.StarShipsList;
import com.example.swapiapi.models.vehicles.Vehicle;
import com.example.swapiapi.models.vehicles.VehiclesList;
import com.example.swapiapi.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VehicleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VehiclesList vehiclesList;
    private VehicleActivityAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        initializeProgressBar();
        initializeRecyclerView();

        if(savedInstanceState == null) {
            NetworkService.getInstance().getSwapApi().getVehiclesList().enqueue(new Callback<VehiclesList>() {
                @Override
                public void onResponse(Call<VehiclesList> call, Response<VehiclesList> response) {
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    vehiclesList = response.body();
                    adapter = new VehicleActivityAdapter(vehiclesList, VehicleActivity.this);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<VehiclesList> call, Throwable t){t.printStackTrace();}
            });
        }
    }

    private void initializeRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_vehicle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initializeProgressBar() {
        progressBar = findViewById(R.id.progress_bar_vehicle);
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("VehiclesList", vehiclesList);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        vehiclesList = (VehiclesList) savedInstanceState.getSerializable("VehiclesList");
        adapter = new VehicleActivityAdapter(vehiclesList, this);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }
}

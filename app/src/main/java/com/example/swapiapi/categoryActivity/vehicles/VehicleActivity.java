package com.example.swapiapi.categoryActivity.vehicles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.example.swapiapi.R;
import com.example.swapiapi.adapters.recyclerview.vehicle.VehicleActivityAdapter;
import com.example.swapiapi.models.vehicles.VehiclesList;
import com.example.swapiapi.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VehicleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VehiclesList vehiclesList;
    private Toolbar toolbar;
    private VehicleActivityAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initializeProgressBar();
        initializeRecyclerView();
        initializeToolbar();

        if(savedInstanceState == null) {
            NetworkService.getInstance().getSwapApi().getVehiclesList().enqueue(new Callback<VehiclesList>() {
                @Override
                public void onResponse(Call<VehiclesList> call, Response<VehiclesList> response) {
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    vehiclesList = response.body();
                    adapter = new VehicleActivityAdapter(vehiclesList);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<VehiclesList> call, Throwable t){t.printStackTrace();}
            });
        }
    }

    private void initializeRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initializeProgressBar() {
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }
    private void initializeToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Vehicle");
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
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("VehiclesList", vehiclesList);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        vehiclesList = (VehiclesList) savedInstanceState.getSerializable("VehiclesList");
        adapter = new VehicleActivityAdapter(vehiclesList);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }
}

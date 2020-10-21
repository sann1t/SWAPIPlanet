package com.example.swapiapi.views.vehicles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.swapiapi.R;
import com.example.swapiapi.adapters.recyclerview.vehicle.VehicleActivityAdapter;
import com.example.swapiapi.models.vehicles.Vehicle;
import com.example.swapiapi.models.vehicles.Vehicles;
import com.example.swapiapi.network.NetworkService;
import com.example.swapiapi.presenters.vehicle.VehiclesPresenter;
import com.example.swapiapi.views.vehicles.info.StartNewActivityCallBack;
import com.example.swapiapi.views.vehicles.info.VehicleActivityInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VehicleActivity extends MvpAppCompatActivity implements VehicleView {

    @InjectPresenter
    VehiclesPresenter vehiclesPresenter;


    private StartNewActivityCallBack callBack;
    private RecyclerView recyclerView;
    private Vehicles vehicles;
    private Toolbar toolbar;
    private VehicleActivityAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        initializeCallBack();

        initializeProgressBar();
        initializeRecyclerView();
        initializeToolbar();
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
    public void showVehicle(Vehicles vehicles) {
        this.vehicles = vehicles;

        adapter = new VehicleActivityAdapter(vehicles, callBack);
        recyclerView.setAdapter(adapter);

        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

    public void initializeCallBack() {
        callBack = new StartNewActivityCallBack() {
            @Override
            public void onClick(Vehicle vehicle) {
                Intent intent = new Intent(getApplicationContext(), VehicleActivityInfo.class);
                intent.putExtra("Vehicle", vehicle);
                startActivity(intent);
            }
        };
    }
}

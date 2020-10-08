package com.example.swapiapi.categoryActivity.planets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.example.swapiapi.R;
import com.example.swapiapi.adapters.recyclerview.PlanetActivityAdapter;
import com.example.swapiapi.models.planets.PlanetsList;
import com.example.swapiapi.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlanetsList planetList;
    private PlanetActivityAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);

        initializeProgressBar();
        initializeRecyclerView();

        if(savedInstanceState == null) {
            NetworkService.getInstance().getSwapApi().getPlanetsList().enqueue(new Callback<PlanetsList>() {
                @Override
                public void onResponse(Call<PlanetsList> call, Response<PlanetsList> response) {
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    planetList = response.body();
                    adapter = new PlanetActivityAdapter(response.body(), PlanetActivity.this);
                    recyclerView.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<PlanetsList> call, Throwable t){t.printStackTrace();}
            });
        }
    }

    private void initializeRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_planet);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initializeProgressBar() {
        progressBar = findViewById(R.id.progress_bar_planet);
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("PlaneList", planetList);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        planetList = (PlanetsList) savedInstanceState.getSerializable("PlaneList");
        adapter = new PlanetActivityAdapter(planetList, this);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }



}

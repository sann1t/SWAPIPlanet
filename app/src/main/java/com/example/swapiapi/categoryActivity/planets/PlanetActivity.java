package com.example.swapiapi.categoryActivity.planets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.example.swapiapi.R;
import com.example.swapiapi.adapters.recyclerview.planet.PlanetActivityAdapter;
import com.example.swapiapi.models.planets.PlanetsList;
import com.example.swapiapi.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlanetsList planetList;
    private Toolbar toolbar;
    private PlanetActivityAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initializeProgressBar();
        initializeRecyclerView();
        initializeToolbar();

        if(savedInstanceState == null) {
            NetworkService.getInstance().getSwapApi().getPlanetsList().enqueue(new Callback<PlanetsList>() {
                @Override
                public void onResponse(Call<PlanetsList> call, Response<PlanetsList> response) {
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    planetList = response.body();
                    adapter = new PlanetActivityAdapter(response.body());
                    recyclerView.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<PlanetsList> call, Throwable t){t.printStackTrace();}
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
        getSupportActionBar().setTitle("Planet");
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
        outState.putSerializable("PlaneList", planetList);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        planetList = (PlanetsList) savedInstanceState.getSerializable("PlaneList");
        adapter = new PlanetActivityAdapter(planetList);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }



}

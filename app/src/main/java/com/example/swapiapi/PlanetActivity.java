package com.example.swapiapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.example.swapiapi.adapters.MyAdapter;
import com.example.swapiapi.models.PlanetList;
import com.example.swapiapi.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlanetList planetList;
    private MyAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeProgressBar();
        initializeRecyclerView();
        if(savedInstanceState == null) {
            NetworkService.getInstance().getSwapApi().getListPlanets().enqueue(new Callback<PlanetList>() {
                @Override
                public void onResponse(Call<PlanetList> call, Response<PlanetList> response) {

                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    planetList = response.body();
                    adapter = new MyAdapter(planetList, PlanetActivity.this);
                    recyclerView.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<PlanetList> call, Throwable t){t.printStackTrace();}
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("PlaneList", planetList);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        planetList = (PlanetList) savedInstanceState.getSerializable("PlaneList");
        adapter = new MyAdapter(planetList, this);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }



}

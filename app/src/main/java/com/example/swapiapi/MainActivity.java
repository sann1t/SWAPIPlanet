package com.example.swapiapi;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.swapiapi.adapters.MyAdapter;
import com.example.swapiapi.models.PlanetList;
import com.example.swapiapi.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeProgressDialog();
        initializeRecyclerView();


        NetworkService.getInstance().getSwapApi().getListPlanets().enqueue(new Callback<PlanetList>() {
            @Override
            public void onResponse(Call<PlanetList> call, Response<PlanetList> response) {
                adapter = new MyAdapter(response.body());
                progressBar.setVisibility(ProgressBar.INVISIBLE);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<PlanetList> call, Throwable t) {
                progressBar.setVisibility(ProgressBar.INVISIBLE);
                t.printStackTrace();
            }
        });
    }

    private void initializeRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initializeProgressDialog() {
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

}

package com.example.swapiapi.categoryActivity.starships;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.example.swapiapi.R;
import com.example.swapiapi.adapters.recyclerview.starship.StarShipActivityAdapter;
import com.example.swapiapi.models.starships.StarShipsList;
import com.example.swapiapi.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StarShipActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private StarShipsList starShipsList;
    private StarShipActivityAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_ship);

        initializeProgressBar();
        initializeRecyclerView();

        if(savedInstanceState == null) {
            NetworkService.getInstance().getSwapApi().getStarShipsList().enqueue(new Callback<StarShipsList>() {
                @Override
                public void onResponse(Call<StarShipsList> call, Response<StarShipsList> response) {
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    starShipsList = response.body();
                    adapter = new StarShipActivityAdapter(starShipsList);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<StarShipsList> call, Throwable t){t.printStackTrace();}
            });
        }
    }

    private void initializeRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_star_ship);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initializeProgressBar() {
        progressBar = findViewById(R.id.progress_bar_star_ship);
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("StarShipsList", starShipsList);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        starShipsList = (StarShipsList) savedInstanceState.getSerializable("StarShipsList");
        adapter = new StarShipActivityAdapter(starShipsList);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }
}

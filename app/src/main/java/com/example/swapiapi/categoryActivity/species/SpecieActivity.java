package com.example.swapiapi.categoryActivity.species;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.example.swapiapi.R;
import com.example.swapiapi.adapters.recyclerview.specie.SpecieActivityAdapter;
import com.example.swapiapi.models.species.SpeciesList;
import com.example.swapiapi.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpecieActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SpeciesList speciesList;
    private SpecieActivityAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specie);

        initializeProgressBar();
        initializeRecyclerView();

        if(savedInstanceState == null) {
            NetworkService.getInstance().getSwapApi().getSpeciesList().enqueue(new Callback<SpeciesList>() {
                @Override
                public void onResponse(Call<SpeciesList> call, Response<SpeciesList> response) {
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    speciesList = response.body();
                    adapter = new SpecieActivityAdapter(speciesList);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<SpeciesList> call, Throwable t){t.printStackTrace();}
            });
        }
    }

    private void initializeRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_specie);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initializeProgressBar() {
        progressBar = findViewById(R.id.progress_bar_specie);
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("SpeciesList", speciesList);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        speciesList = (SpeciesList) savedInstanceState.getSerializable("SpeciesList");
        adapter = new SpecieActivityAdapter(speciesList);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }
}

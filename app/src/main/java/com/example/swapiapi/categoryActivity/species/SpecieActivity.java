package com.example.swapiapi.categoryActivity.species;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.example.swapiapi.R;
import com.example.swapiapi.adapters.recyclerview.specie.SpecieActivityAdapter;
import com.example.swapiapi.models.species.Species;
import com.example.swapiapi.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpecieActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Species speciesList;
    private Toolbar toolbar;
    private SpecieActivityAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initializeProgressBar();
        initializeRecyclerView();
        initializeToolbar();

        if(savedInstanceState == null) {
            NetworkService.getInstance().getSwapApi().getSpeciesList().enqueue(new Callback<Species>() {
                @Override
                public void onResponse(Call<Species> call, Response<Species> response) {
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    speciesList = response.body();
                    adapter = new SpecieActivityAdapter(speciesList);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<Species> call, Throwable t){t.printStackTrace();}
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
        getSupportActionBar().setTitle("Specie");
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
        outState.putSerializable("SpeciesList", speciesList);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        speciesList = (Species) savedInstanceState.getSerializable("SpeciesList");
        adapter = new SpecieActivityAdapter(speciesList);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }
}

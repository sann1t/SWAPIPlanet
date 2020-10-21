package com.example.swapiapi.views.species;

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
import com.example.swapiapi.adapters.recyclerview.specie.SpecieActivityAdapter;
import com.example.swapiapi.models.species.Specie;
import com.example.swapiapi.models.species.Species;
import com.example.swapiapi.network.NetworkService;
import com.example.swapiapi.presenters.species.SpeciesPresenter;
import com.example.swapiapi.views.species.info.SpecieActivityInfo;
import com.example.swapiapi.views.species.info.StartNewActivityCallBack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpecieActivity extends MvpAppCompatActivity implements SpecieView{

    @InjectPresenter
    SpeciesPresenter speciesPresenter;

    private StartNewActivityCallBack callBack;
    private RecyclerView recyclerView;
    private Species species;
    private Toolbar toolbar;
    private SpecieActivityAdapter adapter;
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

    public void initializeCallBack() {
        callBack = new StartNewActivityCallBack() {
            @Override
            public void onClick(Specie specie) {
                Intent intent = new Intent(getApplicationContext(), SpecieActivityInfo.class);
                intent.putExtra("Specie", specie);
                startActivity(intent);
            }
        };
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
    public void showSpecies(Species species) {
        this.species = species;

        adapter = new SpecieActivityAdapter(species, callBack);
        recyclerView.setAdapter(adapter);

        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }
}

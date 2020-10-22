package com.example.swapiapi.views.planets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.swapiapi.R;
import com.example.swapiapi.adapters.recyclerview.planet.PlanetActivityAdapter;
import com.example.swapiapi.models.planets.Planet;
import com.example.swapiapi.models.planets.Planets;
import com.example.swapiapi.presenters.planets.PlanetPresenter;
import com.example.swapiapi.views.planets.info.PlanetActivityInfo;
import com.example.swapiapi.views.planets.info.StartNewActivityCallBack;


public class PlanetActivity extends MvpAppCompatActivity implements PlanetView{

    @InjectPresenter
    PlanetPresenter planetPresenter;

    private StartNewActivityCallBack callBack;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private PlanetActivityAdapter adapter;
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
            public void onClick(Planet planet) {
                Intent intent = new Intent(getApplicationContext(), PlanetActivityInfo.class);
                intent.putExtra("Planet", planet);
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
    public void showPlanet(Planets planets) {
        adapter = new PlanetActivityAdapter(planets, callBack);
        recyclerView.setAdapter(adapter);

        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }
}

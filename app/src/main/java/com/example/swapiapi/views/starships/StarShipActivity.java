package com.example.swapiapi.views.starships;

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
import com.example.swapiapi.adapters.recyclerview.starship.StarShipActivityAdapter;
import com.example.swapiapi.models.starships.StarShip;
import com.example.swapiapi.models.starships.StarShips;
import com.example.swapiapi.presenters.starships.StarShipsPresenter;
import com.example.swapiapi.views.starships.info.StarShipActivityInfo;
import com.example.swapiapi.views.starships.info.StartNewActivityCallBack;

public class StarShipActivity extends MvpAppCompatActivity implements StarShipView {

    @InjectPresenter
    StarShipsPresenter starShipsPresenter;

    private StartNewActivityCallBack callBack;
    private RecyclerView recyclerView;
    private StarShips starShips;
    private Toolbar toolbar;
    private StarShipActivityAdapter adapter;
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
            public void onClick(StarShip starShip) {
                Intent intent = new Intent(getApplicationContext(), StarShipActivityInfo.class);
                intent.putExtra("StarShip", starShip);
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
        getSupportActionBar().setTitle("Star Ship");
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
    public void showStarShips(StarShips starShips) {
        this.starShips = starShips;

        adapter = new StarShipActivityAdapter(starShips, callBack);
        recyclerView.setAdapter(adapter);

        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }
}

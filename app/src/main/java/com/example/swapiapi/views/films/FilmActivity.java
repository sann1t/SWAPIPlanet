package com.example.swapiapi.views.films;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.swapiapi.R;
import com.example.swapiapi.adapters.recyclerview.film.FilmActivityAdapter;
import com.example.swapiapi.models.films.Film;
import com.example.swapiapi.models.films.Films;
import com.example.swapiapi.presenters.films.FilmsPresenter;
import com.example.swapiapi.views.films.info.StartNewActivityCallBack;
import com.example.swapiapi.views.films.info.FilmActivityInfo;

public class FilmActivity extends MvpAppCompatActivity implements FilmView {

    private ProgressBar progressBar;
    private StartNewActivityCallBack callBack;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Toolbar toolbar;
    private Films films;

    @InjectPresenter
    FilmsPresenter filmsPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initializeCallBack();
        initializeProgressBar();
        initializeRecyclerView();
        initializeToolbar();
    }

    public void initializeRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void initializeProgressBar() {
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    public void initializeCallBack() {
        callBack = new StartNewActivityCallBack() {
            @Override
            public void onClick(Film film) {
                Intent intent = new Intent(getApplicationContext(), FilmActivityInfo.class);
                intent.putExtra("Film", film);
                startActivity(intent);
            }
        };
    }

    public void initializeToolbar() {
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Films");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void showFilms(Films films) {
        this.films = films;
        adapter = new FilmActivityAdapter(this.films, callBack);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }
}

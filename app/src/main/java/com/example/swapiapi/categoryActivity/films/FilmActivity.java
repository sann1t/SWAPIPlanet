package com.example.swapiapi.categoryActivity.films;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.example.swapiapi.R;
import com.example.swapiapi.adapters.recyclerview.film.FilmActivityAdapter;
import com.example.swapiapi.adapters.recyclerview.people.PeopleActivityAdapter;
import com.example.swapiapi.models.films.FilmsList;
import com.example.swapiapi.models.peoples.PeoplesList;
import com.example.swapiapi.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Toolbar toolbar;
    private FilmsList filmsList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initializeProgressBar();
        initializeRecyclerView();
        initializeToolbar();

        if (savedInstanceState == null) {
            NetworkService.getInstance().getSwapApi().getFilmsList().enqueue(new Callback<FilmsList>() {
                @Override
                public void onResponse(Call<FilmsList> call, Response<FilmsList> response) {
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    filmsList = response.body();
                    adapter = new FilmActivityAdapter(response.body());
                    recyclerView.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<FilmsList> call, Throwable t) {
                    t.printStackTrace();
                }
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
        getSupportActionBar().setTitle("Films");
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
        outState.putSerializable("FilmsList", filmsList);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        filmsList = (FilmsList) savedInstanceState.getSerializable("FilmsList");
        adapter = new FilmActivityAdapter(filmsList);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }


}

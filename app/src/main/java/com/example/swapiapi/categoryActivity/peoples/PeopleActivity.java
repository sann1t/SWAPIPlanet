package com.example.swapiapi.categoryActivity.peoples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.example.swapiapi.R;
import com.example.swapiapi.adapters.recyclerview.people.PeopleActivityAdapter;
import com.example.swapiapi.models.peoples.Peoples;
import com.example.swapiapi.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private Peoples peoples;
    private PeopleActivityAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initializeProgressBar();
        initializeRecyclerView();
        initializeToolbar();

        if(savedInstanceState == null) {
            NetworkService.getInstance().getSwapApi().getPeoplesList().enqueue(new Callback<Peoples>() {
                @Override
                public void onResponse(Call<Peoples> call, Response<Peoples> response) {
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    peoples = response.body();
                    adapter = new PeopleActivityAdapter(peoples);
                    recyclerView.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<Peoples> call, Throwable t){t.printStackTrace();}
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
        getSupportActionBar().setTitle("People");
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
        outState.putSerializable("PeopleList", peoples);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        peoples = (Peoples) savedInstanceState.getSerializable("PeopleList");
        adapter = new PeopleActivityAdapter(peoples);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

}

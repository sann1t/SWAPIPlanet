package com.example.swapiapi.categoryActivity.peoples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.example.swapiapi.R;
import com.example.swapiapi.adapters.recyclerview.PeopleActivityAdapter;
import com.example.swapiapi.models.peoples.PeoplesList;
import com.example.swapiapi.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PeoplesList peoplesList;
    private PeopleActivityAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        initializeProgressBar();
        initializeRecyclerView();

        if(savedInstanceState == null) {
            NetworkService.getInstance().getSwapApi().getPeoplesList().enqueue(new Callback<PeoplesList>() {
                @Override
                public void onResponse(Call<PeoplesList> call, Response<PeoplesList> response) {
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    peoplesList = response.body();
                    adapter = new PeopleActivityAdapter(peoplesList, PeopleActivity.this);
                    recyclerView.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<PeoplesList> call, Throwable t){t.printStackTrace();}
            });
        }
    }

    private void initializeRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_people);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initializeProgressBar() {
        progressBar = findViewById(R.id.progress_bar_people);
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("PeopleList", peoplesList);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        peoplesList = (PeoplesList) savedInstanceState.getSerializable("PeopleList");
        adapter = new PeopleActivityAdapter(peoplesList, this);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

}

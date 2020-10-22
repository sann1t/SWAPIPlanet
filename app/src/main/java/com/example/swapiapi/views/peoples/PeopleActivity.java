package com.example.swapiapi.views.peoples;

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
import com.example.swapiapi.adapters.recyclerview.people.PeopleActivityAdapter;
import com.example.swapiapi.models.peoples.People;
import com.example.swapiapi.models.peoples.Peoples;
import com.example.swapiapi.presenters.peoples.PeoplesPresenter;
import com.example.swapiapi.views.peoples.info.PeopleActivityInfo;
import com.example.swapiapi.views.peoples.info.StartNewActivityCallBack;
import com.example.swapiapi.views.films.info.FilmActivityInfo;

public class PeopleActivity extends MvpAppCompatActivity implements PeopleView {

    private RecyclerView recyclerView;
    private StartNewActivityCallBack callBack;
    private Toolbar toolbar;
    private Peoples peoples;
    private PeopleActivityAdapter adapter;
    private ProgressBar progressBar;

    @InjectPresenter
    PeoplesPresenter peoplesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initializeCallBack();
        initializeProgressBar();
        initializeRecyclerView();
        initializeToolbar();

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

    public void initializeCallBack() {
        callBack = new StartNewActivityCallBack() {
            @Override
            public void onClick(People people) {
                Intent intent = new Intent(getApplicationContext(), PeopleActivityInfo.class);
                intent.putExtra("People", people);
                startActivity(intent);
            }
        };
    }
    @Override
    public void showPeople(Peoples peoples) {
        this.peoples = peoples;
        adapter = new PeopleActivityAdapter(peoples, callBack);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

}

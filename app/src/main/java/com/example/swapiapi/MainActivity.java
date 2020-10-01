package com.example.swapiapi;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.swapiapi.adapters.MyAdapter;
import com.example.swapiapi.loader.PlanetLoader;
import com.example.swapiapi.models.PlanetList;


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<PlanetList> {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private static final int PLANET_LOADER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeRecyclerView();

        getLoaderManager().initLoader(PLANET_LOADER_ID, null,this);

    }

    private void initializeRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @NonNull
    @Override
    public Loader<PlanetList> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new PlanetLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<PlanetList> loader, PlanetList planetList) {
        adapter = new MyAdapter(planetList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<PlanetList> loader) {

    }
}

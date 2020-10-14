package com.example.swapiapi.categoryActivity.films;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.models.films.Film;
import com.example.swapiapi.models.peoples.People;

public class FilmActivityInfo extends AppCompatActivity {


    private Bundle bundle;
    private Film film;
    private Toolbar toolbar;
    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    private String[] filmInfo;
    private LinearLayout linearLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_info);

        initializeData();
        initializeToolbar();
        initializeInfo();
    }


    private void initializeToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(film.getTitle());
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

    private void initializeInfo() {
        linearLayout = findViewById(R.id.infoCategory);

        for(int i = 0; i < filmInfo.length; i++) {
            TextView info = new TextView(this);
            info.setText(filmInfo[i]);
            info.setGravity(Gravity.START);
            info.setTextSize(16);
            info.setTextColor(Color.BLACK);
            linearLayout.addView(info, params);
        }
    }
    private void initializeData() {
        bundle = getIntent().getExtras();
        film = (Film) bundle.getSerializable("Film");
        String[] info = {"title: " + film.getTitle(), "director: " + film.getDirector(), "producer: " + film.getProducer(),
                "episode id: " + film.getEpisode_id(), "release date: " + film.getRelease_date(),"opening crawl: " + film.getOpening_crawl()};
        filmInfo = info;
    }
}

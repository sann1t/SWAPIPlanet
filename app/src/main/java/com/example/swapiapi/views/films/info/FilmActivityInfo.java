package com.example.swapiapi.views.films.info;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.swapiapi.R;
import com.example.swapiapi.models.films.Film;
import com.example.swapiapi.presenters.films.FilmInfoPresenter;

public class FilmActivityInfo extends MvpAppCompatActivity implements FilmInfoView {

    @InjectPresenter
    FilmInfoPresenter filmInfoPresenter;

    private Toolbar toolbar;
    private LinearLayout linearLayout;
    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_info);
        linearLayout = findViewById(R.id.infoCategory);
    }

    @Override
    public void initializeToolbar(String title) {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
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
    public void createNewInfo(String info) {
        TextView newInfo = new TextView(this);
        newInfo.setText(info);
        newInfo.setGravity(Gravity.START);
        newInfo.setTextSize(16);
        newInfo.setTextColor(Color.BLACK);
        newInfo.setLayoutParams(params);
        linearLayout.addView(newInfo);
    }

    @Override
    public void saveIntent() {
        Bundle bundle = getIntent().getExtras();
        filmInfoPresenter.saveFilmInfo((Film) bundle.getSerializable("Film"));
    }
}

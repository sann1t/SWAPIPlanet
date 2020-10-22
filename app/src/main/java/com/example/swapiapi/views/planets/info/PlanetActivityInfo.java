package com.example.swapiapi.views.planets.info;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.swapiapi.R;
import com.example.swapiapi.models.planets.Planet;
import com.example.swapiapi.presenters.planets.PlanetInfoPresenter;

public class PlanetActivityInfo extends MvpAppCompatActivity implements PlanetInfoView {

    @InjectPresenter
    PlanetInfoPresenter planetInfoPresenter;

    private Toolbar toolbar;
    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    private LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_info);
        linearLayout = findViewById(R.id.infoCategory);
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
        TextView textInfo = new TextView(this);
        textInfo.setText(info);
        textInfo.setGravity(Gravity.START);
        textInfo.setTextSize(16);
        textInfo.setTextColor(Color.BLACK);
        linearLayout.addView(textInfo, params);
    }

    @Override
    public void saveIntent() {
        planetInfoPresenter.savePlanetInfo((Planet) getIntent().getExtras().getSerializable("Planet"));
    }

    @Override
    public void initializeToolbar(String title) {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

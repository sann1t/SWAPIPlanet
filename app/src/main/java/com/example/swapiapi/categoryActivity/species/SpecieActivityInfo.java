package com.example.swapiapi.categoryActivity.species;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.models.species.Specie;

public class SpecieActivityInfo extends AppCompatActivity {

    private Bundle bundle;
    private Specie specie;
    private Toolbar toolbar;
    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    private String[] specieInfo;
    private LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_info);
        initializeData();

        initializeInfo();
        initializeToolbar();
    }

    private void initializeToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(specie.getName());
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

        for(int i = 0; i < specieInfo.length; i++) {
            TextView info = new TextView(this);
            info.setText(specieInfo[i]);
            info.setGravity(Gravity.START);
            info.setTextSize(16);
            info.setTextColor(Color.BLACK);
            linearLayout.addView(info, params);
        }
    }
    private void initializeData() {
        bundle = getIntent().getExtras();
        specie = (Specie) bundle.getSerializable("Specie");
        String[] info = {"name: " + specie.getName(), "average height: " + specie.getAverage_height(), "average lifespan: " + specie.getAverage_lifespan(),
                "classification: " + specie.getClassification(), "designation: " + specie.getDesignation(),
                "eye colors: " + specie.getEye_colors(), "hair colors: " + specie.getHair_colors(),
                "language: " + specie.getLanguage(), "skin colors: " + specie.getSkin_colors()};
        specieInfo = info;
    }
}

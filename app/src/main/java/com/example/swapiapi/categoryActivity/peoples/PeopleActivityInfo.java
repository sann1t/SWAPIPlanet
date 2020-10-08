package com.example.swapiapi.categoryActivity.peoples;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.models.peoples.People;

public class PeopleActivityInfo extends AppCompatActivity {

    private Bundle bundle;
    private People people;
    private Toolbar toolbar;
    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    private String[] peopleInfo;
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
        getSupportActionBar().setTitle(people.getName());
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

        for(int i = 0; i < peopleInfo.length; i++) {
            TextView info = new TextView(this);
            info.setText(peopleInfo[i]);
            info.setGravity(Gravity.START);
            info.setTextSize(16);
            info.setTextColor(Color.BLACK);
            linearLayout.addView(info, params);
        }
    }
    private void initializeData() {
        bundle = getIntent().getExtras();
        people = (People) bundle.getSerializable("People");
        String[] info = {"name: " + people.getName(), "height: " + people.getHeight(), "mass: " + people.getMass(),
                "hair color: " + people.getHair_color(), "skin color: " + people.getSkin_color(),
                "eye color: " + people.getEye_color(), "birth year: " + people.getBirth_year(), "gender: " + people.getGender()};
        peopleInfo = info;
    }
}

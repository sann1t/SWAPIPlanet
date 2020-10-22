package com.example.swapiapi.views.peoples.info;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
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
import com.example.swapiapi.models.films.Film;
import com.example.swapiapi.models.peoples.People;
import com.example.swapiapi.models.peoples.Peoples;
import com.example.swapiapi.presenters.peoples.PeopleInfoPresenter;
import com.example.swapiapi.views.peoples.PeopleView;

public class PeopleActivityInfo extends MvpAppCompatActivity implements PeopleInfoView {

    @InjectPresenter
    PeopleInfoPresenter peopleInfoPresenter;
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
        TextView textInfo = new TextView(this);
        textInfo.setText(info);
        textInfo.setGravity(Gravity.START);
        textInfo.setTextSize(16);
        textInfo.setTextColor(Color.BLACK);
        linearLayout.addView(textInfo, params);
    }

    private void initializeData() {
        bundle = getIntent().getExtras();
        people = (People) bundle.getSerializable("People");
        String[] info = {"name: " + people.getName(), "height: " + people.getHeight(), "mass: " + people.getMass(),
                "hair color: " + people.getHair_color(), "skin color: " + people.getSkin_color(),
                "eye color: " + people.getEye_color(), "birth year: " + people.getBirth_year(), "gender: " + people.getGender()};
        peopleInfo = info;
    }


    @Override
    public void saveIntent() {
        Bundle bundle = getIntent().getExtras();
        peopleInfoPresenter.savePeopleInfo((People) bundle.getSerializable("People"));
    }
}

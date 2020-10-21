package com.example.swapiapi.views.starships.info;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
import com.example.swapiapi.models.starships.StarShip;
import com.example.swapiapi.presenters.starships.StarShipInfoPresenter;

public class StarShipActivityInfo extends MvpAppCompatActivity implements StarShipInfoView{

    @InjectPresenter
    StarShipInfoPresenter starShipInfoPresenter;

    private StartNewActivityCallBack callBack;
    private Toolbar toolbar;
    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    private LinearLayout linearLayout;


    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_info);
        linearLayout = findViewById(R.id.infoCategory);
        initializeCallBack();
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
            public void onClick(StarShip starShip) {
                Intent intent = new Intent(getApplicationContext(), StarShipActivityInfo.class);
                intent.putExtra("StarShip", starShip);
                startActivity(intent);
            }
        };
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
        starShipInfoPresenter.saveStarShipInfo((StarShip) getIntent().getExtras().getSerializable("StarShip"));
    }

    @Override
    public void initializeToolbar(String title) {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

package com.example.swapiapi;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.swapiapi.models.Planet;
import com.example.swapiapi.models.PlanetList;
import com.example.swapiapi.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private LinearLayout.LayoutParams gravityCenter = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout) findViewById(R.id.layoutMain);
        NetworkService.getInstance().getSwapApi().getListPlanets().enqueue(new Callback<PlanetList>() {
            @Override
            public void onResponse(Call<PlanetList> call, Response<PlanetList> response) {
                initializeTextViewers(response.body());
            }

            @Override
            public void onFailure(Call<PlanetList> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


    public void initializeTextViewers(PlanetList planetList) {
        for(Planet planet: planetList.getResults()){
            TextView textView = new TextView(getApplicationContext());
            textView.setText(planet.getName());
            textView.setTextSize(30);
            gravityCenter.gravity = Gravity.CENTER;
            linearLayout.addView(textView, gravityCenter);
        }
    }

}

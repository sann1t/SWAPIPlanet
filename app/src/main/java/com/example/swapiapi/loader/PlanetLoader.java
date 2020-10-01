package com.example.swapiapi.loader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.content.Loader;

import com.example.swapiapi.models.PlanetList;
import com.example.swapiapi.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetLoader extends Loader<PlanetList> {

    private PlanetList planetList;

    public PlanetLoader(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        if(planetList != null) {
            deliverResult(planetList);
        }else {
            forceLoad();
        }

    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();

        NetworkService.getInstance().getSwapApi().getListPlanets().enqueue(new Callback<PlanetList>() {
            @Override
            public void onResponse(Call<PlanetList> call, Response<PlanetList> response) {
               planetList = response.body();
                deliverResult(planetList);
            }

            @Override
            public void onFailure(Call<PlanetList> call, Throwable t) {
                t.printStackTrace();
                deliverResult(null);
            }
        });
    }

    @Override
    protected void onStopLoading() {
        NetworkService.getInstance().getSwapApi().getListPlanets().cancel();
        super.onStopLoading();
    }
}

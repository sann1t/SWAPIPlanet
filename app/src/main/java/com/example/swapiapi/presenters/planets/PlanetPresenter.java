package com.example.swapiapi.presenters.planets;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.swapiapi.models.planets.Planets;
import com.example.swapiapi.network.NetworkService;
import com.example.swapiapi.views.planets.PlanetView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@InjectViewState
public class PlanetPresenter extends MvpPresenter<PlanetView> {

    private Planets planets;

    @Override
    protected void onFirstViewAttach() {
        NetworkService.getInstance().getSwapApi().getPlanetsList().enqueue(new Callback<Planets>() {
            @Override
            public void onResponse(Call<Planets> call, Response<Planets> response) {
                planets = response.body();
                getViewState().showPlanet(planets);
            }

            @Override
            public void onFailure(Call<Planets> call, Throwable t){t.printStackTrace();}
        });
    }
}

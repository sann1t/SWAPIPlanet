package com.example.swapiapi.presenters.starships;

import android.widget.ProgressBar;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.swapiapi.models.starships.StarShips;
import com.example.swapiapi.network.NetworkService;
import com.example.swapiapi.views.starships.StarShipView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@InjectViewState
public class StarShipsPresenter extends MvpPresenter<StarShipView> {

    private StarShips starShips;

    @Override
    protected void onFirstViewAttach() {
        NetworkService.getInstance().getSwapApi().getStarShipsList().enqueue(new Callback<StarShips>() {
            @Override
            public void onResponse(Call<StarShips> call, Response<StarShips> response) {
                starShips = response.body();
                getViewState().showStarShips(starShips);
            }

            @Override
            public void onFailure(Call<StarShips> call, Throwable t){t.printStackTrace();}
        });
    }
}

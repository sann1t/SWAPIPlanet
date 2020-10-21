package com.example.swapiapi.presenters.films;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.swapiapi.models.films.Film;
import com.example.swapiapi.models.films.Films;
import com.example.swapiapi.network.NetworkService;
import com.example.swapiapi.views.films.FilmView;
import com.example.swapiapi.views.films.info.FilmActivityInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@InjectViewState
public class FilmsPresenter extends MvpPresenter<FilmView> {

    private Films films;

    @Override
    protected void onFirstViewAttach() {
        getResultFromServer();
    }

    public void getResultFromServer() {
        NetworkService.getInstance().getSwapApi().getFilmsList().enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                films = response.body();
                getViewState().showFilms(films);
            }

            @Override
            public void onFailure(Call<Films> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

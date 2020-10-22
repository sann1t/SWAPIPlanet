package com.example.swapiapi.presenters.species;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.swapiapi.models.species.Species;
import com.example.swapiapi.network.NetworkService;
import com.example.swapiapi.views.species.SpecieView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@InjectViewState
public class SpeciesPresenter extends MvpPresenter<SpecieView> {

    private Species species;

    @Override
    protected void onFirstViewAttach() {
        NetworkService.getInstance().getSwapApi().getSpeciesList().enqueue(new Callback<Species>() {
            @Override
            public void onResponse(Call<Species> call, Response<Species> response) {
                species = response.body();
                getViewState().showSpecies(species);
            }

            @Override
            public void onFailure(Call<Species> call, Throwable t){t.printStackTrace();}
        });
    }
}

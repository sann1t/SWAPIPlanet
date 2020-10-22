package com.example.swapiapi.presenters.peoples;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.swapiapi.models.peoples.Peoples;
import com.example.swapiapi.network.NetworkService;
import com.example.swapiapi.views.peoples.PeopleActivity;
import com.example.swapiapi.views.peoples.PeopleView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@InjectViewState
public class PeoplesPresenter extends MvpPresenter<PeopleView> {

    private Peoples peoples;

    @Override
    protected void onFirstViewAttach() {
        getResponseFromServer();
    }

    public void getResponseFromServer() {
        NetworkService.getInstance().getSwapApi().getPeoplesList().enqueue(new Callback<Peoples>() {
            @Override
            public void onResponse(Call<Peoples> call, Response<Peoples> response) {
                peoples = response.body();
                getViewState().showPeople(peoples);
            }

            @Override
            public void onFailure(Call<Peoples> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

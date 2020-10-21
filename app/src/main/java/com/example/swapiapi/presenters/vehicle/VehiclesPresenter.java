package com.example.swapiapi.presenters.vehicle;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.swapiapi.models.vehicles.Vehicles;
import com.example.swapiapi.network.NetworkService;
import com.example.swapiapi.views.vehicles.VehicleView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@InjectViewState
public class VehiclesPresenter extends MvpPresenter<VehicleView> {
    private Vehicles vehicles;
    @Override
    protected void onFirstViewAttach() {
        NetworkService.getInstance().getSwapApi().getVehiclesList().enqueue(new Callback<Vehicles>() {
            @Override
            public void onResponse(Call<Vehicles> call, Response<Vehicles> response) {
                vehicles = response.body();
                getViewState().showVehicle(vehicles);
            }
            @Override
            public void onFailure(Call<Vehicles> call, Throwable t){t.printStackTrace();}
        });
    }
}

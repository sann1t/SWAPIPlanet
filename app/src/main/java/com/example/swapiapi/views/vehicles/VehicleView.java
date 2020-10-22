package com.example.swapiapi.views.vehicles;

import com.arellomobile.mvp.MvpView;
import com.example.swapiapi.models.vehicles.Vehicles;

public interface VehicleView extends MvpView {
    void showVehicle(Vehicles vehicles);
}

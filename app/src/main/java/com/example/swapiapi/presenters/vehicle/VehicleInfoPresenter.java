package com.example.swapiapi.presenters.vehicle;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.swapiapi.models.vehicles.Vehicle;
import com.example.swapiapi.views.vehicles.info.VehicleInfoView;

@InjectViewState
public class VehicleInfoPresenter extends MvpPresenter<VehicleInfoView> {

    private Vehicle vehicle;
    private String[] vehicleInfo;

    @Override
    protected void onFirstViewAttach() {
        getViewState().saveIntent();
        getViewState().initializeToolbar(vehicle.getName());
        createNewTextInfo();
    }

    public void createNewTextInfo() {
        for(int i = 0; i < vehicleInfo.length; i++) {
            getViewState().createNewInfo(vehicleInfo[i]);
        }
    }

    public void saveVehicleInfo(Vehicle vehicle) {
        this.vehicle = vehicle;
        String[] info = {"cargo capacity: " + vehicle.getCargo_capacity(), "consumables: " + vehicle.getConsumables(),
                "cost in credits: " + vehicle.getCost_in_credits(), "crew: " + vehicle.getCrew(), "length: " + vehicle.getLength(), "manufacturer: " + vehicle.getManufacturer(),
                "max atmosphering speed: " + vehicle.getMax_atmosphering_speed(), "model: " + vehicle.getModel(), "passengers: " + vehicle.getPassengers(), "vehicle class: " + vehicle.getVehicle_class()};
        vehicleInfo = info;
    }
}

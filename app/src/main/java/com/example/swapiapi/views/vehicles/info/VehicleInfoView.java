package com.example.swapiapi.views.vehicles.info;

import com.arellomobile.mvp.MvpView;

public interface VehicleInfoView extends MvpView {
    void createNewInfo(String info);
    void saveIntent();
    void initializeToolbar(String title);
}

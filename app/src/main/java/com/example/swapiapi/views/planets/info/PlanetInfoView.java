package com.example.swapiapi.views.planets.info;

import com.arellomobile.mvp.MvpView;

public interface PlanetInfoView extends MvpView {
    void createNewInfo(String info);
    void saveIntent();
    void initializeToolbar(String title);
}

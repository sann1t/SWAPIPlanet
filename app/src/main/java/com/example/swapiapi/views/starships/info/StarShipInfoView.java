package com.example.swapiapi.views.starships.info;

import com.arellomobile.mvp.MvpView;

public interface StarShipInfoView extends MvpView {
    void createNewInfo(String info);
    void saveIntent();
    void initializeToolbar(String title);
}

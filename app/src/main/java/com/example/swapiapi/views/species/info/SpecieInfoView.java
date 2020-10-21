package com.example.swapiapi.views.species.info;

import com.arellomobile.mvp.MvpView;

public interface SpecieInfoView extends MvpView {
    void createNewInfo(String info);
    void saveIntent();
    void initializeToolbar(String title);
}

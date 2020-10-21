package com.example.swapiapi.views.films.info;

import com.arellomobile.mvp.MvpView;

public interface FilmInfoView extends MvpView {
    void createNewInfo(String info);
    void saveIntent();
    void initializeToolbar(String title);
}

package com.example.swapiapi.views.peoples.info;

import com.arellomobile.mvp.MvpView;

public interface PeopleInfoView extends MvpView  {
    void createNewInfo(String info);
    void saveIntent();
    void initializeToolbar(String title);
}

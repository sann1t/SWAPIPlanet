package com.example.swapiapi.views.peoples;

import com.arellomobile.mvp.MvpView;
import com.example.swapiapi.models.peoples.Peoples;

public interface PeopleView extends MvpView {
    void showPeople(Peoples peoples);
}

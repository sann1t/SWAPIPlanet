package com.example.swapiapi.views.starships;

import com.arellomobile.mvp.MvpView;
import com.example.swapiapi.models.starships.StarShips;

public interface StarShipView extends MvpView {
    void showStarShips(StarShips starShips);
}

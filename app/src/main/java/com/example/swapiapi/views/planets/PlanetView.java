package com.example.swapiapi.views.planets;

import com.arellomobile.mvp.MvpView;
import com.example.swapiapi.models.planets.Planets;

public interface PlanetView extends MvpView {
    void showPlanet(Planets planets);
}

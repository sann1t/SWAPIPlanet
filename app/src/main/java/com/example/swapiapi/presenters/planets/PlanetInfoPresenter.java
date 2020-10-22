package com.example.swapiapi.presenters.planets;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.swapiapi.models.planets.Planet;
import com.example.swapiapi.views.planets.PlanetView;
import com.example.swapiapi.views.planets.info.PlanetInfoView;

@InjectViewState
public class PlanetInfoPresenter extends MvpPresenter<PlanetInfoView> {

    private Planet planet;
    private String[] planetInfo;

    @Override
    protected void onFirstViewAttach() {
        getViewState().saveIntent();
        getViewState().initializeToolbar(planet.getName());
        createNewInfo();
    }

    public void createNewInfo() {
        for(int i = 0; i < planetInfo.length; i++) {
            getViewState().createNewInfo(planetInfo[i]);
        }
    }

    public void savePlanetInfo(Planet planet) {
        this.planet = planet;

        String[] info = {"rotation period: " + planet.getRotationPeriod(), "orbital period: " + planet.getOrbitalPeriod(),
                "diameter: " + planet.getDiameter(), "climate: " + planet.getClimate(), "gravity: " + planet.getGravity(), "terrain: " + planet.getTerrain(),
                "surface water: " + planet.getSurfaceWater(), "population: " + planet.getPopulation()};
        planetInfo = info;
    }
}

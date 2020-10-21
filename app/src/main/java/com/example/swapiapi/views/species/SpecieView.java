package com.example.swapiapi.views.species;

import com.arellomobile.mvp.MvpView;
import com.example.swapiapi.models.species.Species;

public interface SpecieView extends MvpView {
    void showSpecies(Species species);
}

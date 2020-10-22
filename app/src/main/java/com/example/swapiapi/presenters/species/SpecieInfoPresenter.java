package com.example.swapiapi.presenters.species;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.swapiapi.models.species.Specie;
import com.example.swapiapi.views.species.info.SpecieInfoView;

@InjectViewState
public class SpecieInfoPresenter extends MvpPresenter<SpecieInfoView> {

    private Specie specie;
    private String[] specieInfo;

    @Override
    protected void onFirstViewAttach() {
        getViewState().saveIntent();
        getViewState().initializeToolbar(specie.getName());
        createNewInfo();
    }

    public void createNewInfo() {
        for(int i = 0; i < specieInfo.length; i++) {
            getViewState().createNewInfo(specieInfo[i]);
        }
    }

    public void saveSpecieIntent(Specie specie) {
        this.specie = specie;
        
        String[] info = {"average height: " + specie.getAverage_height(), "average lifespan: " + specie.getAverage_lifespan(),
                "classification: " + specie.getClassification(), "designation: " + specie.getDesignation(),
                "eye colors: " + specie.getEye_colors(), "hair colors: " + specie.getHair_colors(),
                "language: " + specie.getLanguage(), "skin colors: " + specie.getSkin_colors()};
        specieInfo = info;
    }
}

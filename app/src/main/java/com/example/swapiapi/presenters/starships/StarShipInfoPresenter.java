package com.example.swapiapi.presenters.starships;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.swapiapi.models.starships.StarShip;
import com.example.swapiapi.views.starships.info.StarShipInfoView;

@InjectViewState
public class StarShipInfoPresenter extends MvpPresenter<StarShipInfoView> {

    private StarShip starShip;
    private String[] starShipInfo;

    @Override
    protected void onFirstViewAttach() {
        getViewState().saveIntent();
        getViewState().initializeToolbar(starShip.getName());
        createNewInfo();
    }

    public void createNewInfo() {
        for(int i = 0; i < starShipInfo.length; i++) {
            getViewState().createNewInfo(starShipInfo[i]);
        }
    }
    public void saveStarShipInfo(StarShip starShip) {
        this.starShip = starShip;

        String[] info = {"MGLT: " + starShip.getMGLT(), "cargo capacity: " + starShip.getCargo_capacity(),
                "consumables: " + starShip.getConsumables(), "cost in credits: " + starShip.getCost_in_credits(), "crew: " + starShip.getCrew(),
                "hyperdrive rating: " + starShip.getHyperdrive_rating(), "length: " + starShip.getLength(), "manufacturer: " + starShip.getManufacturer(),
                "max atmosphering speed: " + starShip.getMax_atmosphering_speed(), "model: " + starShip.getModel(), "passengers: " + starShip.getPassengers()};

        starShipInfo = info;
    }
}

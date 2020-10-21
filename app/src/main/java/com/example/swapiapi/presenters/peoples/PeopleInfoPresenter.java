package com.example.swapiapi.presenters.peoples;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.swapiapi.models.peoples.People;
import com.example.swapiapi.views.peoples.info.PeopleInfoView;

@InjectViewState
public class PeopleInfoPresenter extends MvpPresenter<PeopleInfoView> {


    private People people;
    private String[] peopleInfo;

    @Override
    protected void onFirstViewAttach() {
        getViewState().saveIntent();
        getViewState().initializeToolbar(people.getName());
        createNewTextInfo();
    }

    public void createNewTextInfo() {
        for(int i = 0; i < peopleInfo.length; i++) {
            getViewState().createNewInfo(peopleInfo[i]);
        }
    }

    public void savePeopleInfo(People people) {
        this.people = people;
        String[] info = {"name: " + people.getName(), "height: " + people.getHeight(), "mass: " + people.getMass(),
                "hair color: " + people.getHair_color(), "skin color: " + people.getSkin_color(),
                "eye color: " + people.getEye_color(), "birth year: " + people.getBirth_year(), "gender: " + people.getGender()};
        peopleInfo = info;
    }
}

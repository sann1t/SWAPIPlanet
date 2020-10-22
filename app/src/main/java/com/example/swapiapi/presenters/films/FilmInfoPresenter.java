package com.example.swapiapi.presenters.films;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.swapiapi.models.films.Film;
import com.example.swapiapi.views.films.info.FilmInfoView;

@InjectViewState
public class FilmInfoPresenter extends MvpPresenter<FilmInfoView> {

    private String[] filmInfo;
    private Film film;

    @Override
    protected void onFirstViewAttach() {
        getViewState().saveIntent();
        getViewState().initializeToolbar(film.getTitle());
        createNewTextInfo();
    }

    public void createNewTextInfo() {
        for(int i = 0; i < filmInfo.length; i++) {
            getViewState().createNewInfo(filmInfo[i]);
        }
    }

    public void saveFilmInfo(Film film) {
        this.film = film;
        String[] info = {"director: " + film.getDirector(), "producer: " + film.getProducer(),
                "episode id: " + film.getEpisode_id(), "release date: " + film.getRelease_date(),"opening crawl: " + film.getOpening_crawl()};
        filmInfo = info;
    }

}

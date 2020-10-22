package com.example.swapiapi.views.films;

import com.arellomobile.mvp.MvpView;
import com.example.swapiapi.models.films.Films;

public interface FilmView extends MvpView {
    void showFilms(Films films);
}

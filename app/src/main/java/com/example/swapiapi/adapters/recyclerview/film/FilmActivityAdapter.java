package com.example.swapiapi.adapters.recyclerview.film;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.swapiapi.R;
import com.example.swapiapi.categoryActivity.films.FilmActivity;
import com.example.swapiapi.models.films.Film;
import com.example.swapiapi.models.films.FilmsList;

import java.util.List;

public class FilmActivityAdapter extends RecyclerView.Adapter<FilmActivityViewHolder> {

    private List<Film> filmsList;

    public FilmActivityAdapter(FilmsList filmsList) {
        this.filmsList = filmsList.getResults();
    }

    @NonNull
    @Override
    public FilmActivityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_category_activity, viewGroup, false);

        return new FilmActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmActivityViewHolder filmActivityViewHolder, int i) {
        filmActivityViewHolder.bind(filmsList.get(i));
    }

    @Override
    public int getItemCount() {
        return filmsList.size();
    }
}

package com.example.swapiapi.adapters.recyclerview.film;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.categoryActivity.films.FilmActivityInfo;
import com.example.swapiapi.models.films.Film;

public class FilmActivityViewHolder extends RecyclerView.ViewHolder {

    private Film film;
    private TextView name;

    public FilmActivityViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity();
            }
        });
    }


    private void startNewActivity() {
        Intent intent = new Intent(itemView.getContext(), FilmActivityInfo.class);
        intent.putExtra("Film", film);
        itemView.getContext().startActivity(intent);
    }

    protected void bind(Film film) {
        this.film = film;
        name.setText(film.getTitle());
    }
}

package com.example.swapiapi.adapters.recyclerview.film;

import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.views.films.info.StartNewActivityCallBack;
import com.example.swapiapi.models.RandomColor;
import com.example.swapiapi.models.RandomColorInterface;
import com.example.swapiapi.models.films.Film;

public class FilmActivityViewHolder extends RecyclerView.ViewHolder {


    private Film film;
    private StartNewActivityCallBack callBack;
    private TextView name;
    private TextView imageName;
    private RandomColorInterface randomColorInterface;
    private GradientDrawable gradientDrawable;

    public FilmActivityViewHolder(@NonNull final View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        imageName = itemView.findViewById(R.id.image_text);
        randomColorInterface = new RandomColor();
        gradientDrawable = (GradientDrawable) itemView.getResources().getDrawable(R.drawable.image_style);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onClick(film);
            }
        });
    }

    protected void bind(Film film, StartNewActivityCallBack callBack) {
        this.callBack = callBack;
        this.film = film;
        imageName.setText(film.getTitle().substring(0,1));
        gradientDrawable.setColor(randomColorInterface.getRandomColor());
        name.setText(film.getTitle());
    }
}

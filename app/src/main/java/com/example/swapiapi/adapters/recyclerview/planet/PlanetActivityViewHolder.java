package com.example.swapiapi.adapters.recyclerview.planet;

import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.models.RandomColor;
import com.example.swapiapi.models.RandomColorInterface;
import com.example.swapiapi.models.planets.Planet;
import com.example.swapiapi.views.planets.info.StartNewActivityCallBack;

public class PlanetActivityViewHolder extends RecyclerView.ViewHolder {

    private Planet planet;
    private TextView name;
    private TextView imageName;
    private RandomColorInterface randomColorInterface;
    private GradientDrawable gradientDrawable;
    private StartNewActivityCallBack callBack;

    public PlanetActivityViewHolder(@NonNull final View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        imageName = itemView.findViewById(R.id.image_text);
        randomColorInterface = new RandomColor();
        gradientDrawable = (GradientDrawable) itemView.getResources().getDrawable(R.drawable.image_style);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onClick(planet);
            }
        });
    }


    protected void bind(Planet planet, StartNewActivityCallBack callBack) {
        this.callBack = callBack;
        this.planet = planet;
        imageName.setText(planet.getName().substring(0,1));
        gradientDrawable.setColor(randomColorInterface.getRandomColor());
        name.setText(planet.getName());
    }
}
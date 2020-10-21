package com.example.swapiapi.adapters.recyclerview.starship;

import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.models.RandomColor;
import com.example.swapiapi.models.RandomColorInterface;
import com.example.swapiapi.models.starships.StarShip;
import com.example.swapiapi.views.starships.info.StartNewActivityCallBack;

public class StarShipActivityViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private StarShip starShip;
    private StartNewActivityCallBack callBack;
    private TextView imageName;
    private RandomColorInterface randomColorInterface;
    private GradientDrawable gradientDrawable;


    public StarShipActivityViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        imageName = itemView.findViewById(R.id.image_text);
        randomColorInterface = new RandomColor();
        gradientDrawable = (GradientDrawable) itemView.getResources().getDrawable(R.drawable.image_style);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onClick(starShip);
            }
        });
    }

    public void bind(StarShip starShip, StartNewActivityCallBack callBack) {
        this.callBack = callBack;
        this.starShip = starShip;
        imageName.setText(starShip.getName().substring(0,1));
        gradientDrawable.setColor(randomColorInterface.getRandomColor());
        name.setText(starShip.getName());
    }
}
package com.example.swapiapi.adapters.recyclerview.specie;

import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.models.RandomColor;
import com.example.swapiapi.models.RandomColorInterface;
import com.example.swapiapi.models.species.Specie;
import com.example.swapiapi.views.species.info.StartNewActivityCallBack;

public class SpecieActivityViewHolder extends RecyclerView.ViewHolder {

    private StartNewActivityCallBack callBack;
    private Specie specie;
    private TextView name;
    private TextView imageName;
    private RandomColorInterface randomColorInterface;
    private GradientDrawable gradientDrawable;

    public SpecieActivityViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        imageName = itemView.findViewById(R.id.image_text);
        randomColorInterface = new RandomColor();
        gradientDrawable = (GradientDrawable) itemView.getResources().getDrawable(R.drawable.image_style);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onClick(specie);
            }
        });
    }

    public void bind(Specie specie, StartNewActivityCallBack callBack){
        this.callBack = callBack;
        this.specie = specie;
        imageName.setText(specie.getName().substring(0,1));
        gradientDrawable.setColor(randomColorInterface.getRandomColor());
        name.setText(specie.getName());
    }
}
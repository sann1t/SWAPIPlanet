package com.example.swapiapi.adapters.recyclerview.starship;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.categoryActivity.starships.StarShipActivityInfo;
import com.example.swapiapi.models.starships.StarShip;

public class StarShipActivityViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private StarShip starShip;


    public StarShipActivityViewHolder(@NonNull View itemView) {
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
        Intent intent = new Intent(itemView.getContext(), StarShipActivityInfo.class);
        intent.putExtra("StarShip", starShip);
        itemView.getContext().startActivity(intent);
    }

    public void bind(StarShip starShip) {
        this.starShip = starShip;

        name.setText(starShip.getName());
    }
}
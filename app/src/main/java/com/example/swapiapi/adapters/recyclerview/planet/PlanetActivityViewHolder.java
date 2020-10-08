package com.example.swapiapi.adapters.recyclerview.planet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.categoryActivity.planets.PlanetActivityInfo;
import com.example.swapiapi.models.planets.Planet;

public class PlanetActivityViewHolder extends RecyclerView.ViewHolder {

    private Planet planet;
    private TextView name;

    public PlanetActivityViewHolder(@NonNull final View itemView) {
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
        Intent intent = new Intent(itemView.getContext(), PlanetActivityInfo.class);
        intent.putExtra("Planet", planet);
        itemView.getContext().startActivity(intent);
    }

    protected void bind(Planet planet) {
        this.planet = planet;
        name.setText(planet.getName());
    }
}
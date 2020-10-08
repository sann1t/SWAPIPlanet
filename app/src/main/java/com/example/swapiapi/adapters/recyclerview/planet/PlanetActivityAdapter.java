package com.example.swapiapi.adapters.recyclerview.planet;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.categoryActivity.planets.PlanetActivity;
import com.example.swapiapi.categoryActivity.planets.PlanetActivityInfo;
import com.example.swapiapi.models.planets.Planet;
import com.example.swapiapi.models.planets.PlanetsList;

import java.util.List;

public class PlanetActivityAdapter extends RecyclerView.Adapter<PlanetActivityViewHolder> {

    private List<Planet> planetList;

    public PlanetActivityAdapter(PlanetsList planetList) {
        this.planetList = planetList.getResults();
    }


    @NonNull
    @Override
    public PlanetActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category_activity, parent, false);
        return new PlanetActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetActivityViewHolder holder, int i) {
        holder.bind(planetList.get(i));
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }
}

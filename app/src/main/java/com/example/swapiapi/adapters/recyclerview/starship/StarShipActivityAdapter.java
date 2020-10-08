package com.example.swapiapi.adapters.recyclerview.starship;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.categoryActivity.starships.StarShipActivityInfo;
import com.example.swapiapi.models.starships.StarShip;
import com.example.swapiapi.models.starships.StarShipsList;


import java.util.List;

public class StarShipActivityAdapter extends RecyclerView.Adapter<StarShipActivityViewHolder> {

    private List<StarShip> starShipList;

    public StarShipActivityAdapter(StarShipsList starShipsList) {
        this.starShipList = starShipsList.getResults();
    }

    @NonNull
    @Override
    public StarShipActivityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_category_activity, viewGroup, false);

        return new StarShipActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarShipActivityViewHolder starShipActivityViewHolder, int i) {
        starShipActivityViewHolder.bind(starShipList.get(i));
    }

    @Override
    public int getItemCount() {
        return starShipList.size();
    }

}

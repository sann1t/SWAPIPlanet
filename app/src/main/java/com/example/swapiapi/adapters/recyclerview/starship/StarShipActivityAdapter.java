package com.example.swapiapi.adapters.recyclerview.starship;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.swapiapi.R;
import com.example.swapiapi.models.starships.StarShip;
import com.example.swapiapi.models.starships.StarShips;
import com.example.swapiapi.views.starships.info.StartNewActivityCallBack;


import java.util.List;

public class StarShipActivityAdapter extends RecyclerView.Adapter<StarShipActivityViewHolder> {

    private List<StarShip> starShipList;
    private StartNewActivityCallBack callBack;

    public StarShipActivityAdapter(StarShips starShips, StartNewActivityCallBack callBack) {
        this.callBack = callBack;
        this.starShipList = starShips.getResults();
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
        starShipActivityViewHolder.bind(starShipList.get(i), callBack);
    }

    @Override
    public int getItemCount() {
        return starShipList.size();
    }

}

package com.example.swapiapi.adapters.recyclerview.specie;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.categoryActivity.species.SpecieActivityInfo;
import com.example.swapiapi.models.species.Specie;
import com.example.swapiapi.models.species.SpeciesList;

import java.util.List;

public class SpecieActivityAdapter extends RecyclerView.Adapter<SpecieActivityViewHolder> {

    private List<Specie> specieList;

    public SpecieActivityAdapter(SpeciesList speciesList) {
        this.specieList = speciesList.getResults();
    }

    @NonNull
    @Override
    public SpecieActivityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_category_activity, viewGroup, false);

        return new SpecieActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecieActivityViewHolder specieActivityViewHolder, int i) {
        specieActivityViewHolder.bind(specieList.get(i));
    }

    @Override
    public int getItemCount() {
        return specieList.size();
    }
}

package com.example.swapiapi.adapters.recyclerview.specie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.swapiapi.R;
import com.example.swapiapi.models.species.Specie;
import com.example.swapiapi.models.species.Species;

import java.util.List;

public class SpecieActivityAdapter extends RecyclerView.Adapter<SpecieActivityViewHolder> {

    private List<Specie> specieList;

    public SpecieActivityAdapter(Species speciesList) {
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

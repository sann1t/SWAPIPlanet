package com.example.swapiapi.adapters.recyclerview;

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

public class SpecieActivityAdapter extends RecyclerView.Adapter<SpecieActivityAdapter.SpecieActivityViewHolder> {

    private List<Specie> specieList;
    private Context parent;

    public SpecieActivityAdapter(SpeciesList speciesList, Context parent) {
        this.specieList = speciesList.getResults();
        this.parent = parent;
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

    public class SpecieActivityViewHolder extends RecyclerView.ViewHolder {

        private Specie specie;
        private TextView name;

        public SpecieActivityViewHolder(@NonNull View itemView) {
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
            Intent intent = new Intent(parent, SpecieActivityInfo.class);
            intent.putExtra("Specie", specie);
            parent.startActivity(intent);
        }

        public void bind(Specie specie){
            this.specie = specie;

            name.setText(specie.getName());
        }
    }
}

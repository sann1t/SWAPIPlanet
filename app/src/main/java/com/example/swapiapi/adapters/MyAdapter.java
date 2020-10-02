package com.example.swapiapi.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.models.Planet;
import com.example.swapiapi.models.PlanetList;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Planet> planetList;

    public MyAdapter(PlanetList planetList) {
        this.planetList = planetList.getResults();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.bind(planetList.get(i));
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }

        protected void bind(Planet planet) {
            name.setText(planet.getName());
        }
    }
}

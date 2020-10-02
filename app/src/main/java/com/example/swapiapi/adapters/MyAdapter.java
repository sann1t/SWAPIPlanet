package com.example.swapiapi.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.swapiapi.PlanetInfo;
import com.example.swapiapi.R;
import com.example.swapiapi.models.Planet;
import com.example.swapiapi.models.PlanetList;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Planet> planetList;
    private Context parent;
    private Intent planetInfoActivity;
    private Bundle saveInstanceState;

    public MyAdapter(PlanetList planetList, Context parent) {
        this.planetList = planetList.getResults();
        this.parent = parent;
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


        private Planet planet;
        private TextView name;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startPlatenInfoActivity();
                }
            });
        }


        protected void startPlatenInfoActivity() {
            planetInfoActivity = new Intent(parent, PlanetInfo.class);
            planetInfoActivity.putExtra("Planet", planet);

            parent.startActivity(planetInfoActivity);
        }
        protected void bind(Planet planet) {
            this.planet = planet;
            name.setText(planet.getName());
        }
    }
}

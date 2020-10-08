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
import com.example.swapiapi.categoryActivity.peoples.PeopleActivityInfo;
import com.example.swapiapi.categoryActivity.planets.PlanetActivityInfo;
import com.example.swapiapi.models.peoples.People;
import com.example.swapiapi.models.peoples.PeoplesList;
import com.example.swapiapi.models.planets.Planet;
import com.example.swapiapi.models.planets.PlanetsList;
import com.example.swapiapi.models.species.Specie;
import com.example.swapiapi.models.species.SpeciesList;
import com.example.swapiapi.models.starships.StarShip;
import com.example.swapiapi.models.starships.StarShipsList;
import com.example.swapiapi.models.vehicles.Vehicle;
import com.example.swapiapi.models.vehicles.VehiclesList;

import java.util.List;

public class PlanetActivityAdapter extends RecyclerView.Adapter<PlanetActivityAdapter.MyViewHolder> {

    private List<Planet> planetList;
    private Context parent;

    public PlanetActivityAdapter(PlanetsList planetList, Context parent) {
        this.planetList = planetList.getResults();
        this.parent = parent;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category_activity, parent, false);
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
            name = itemView.findViewById(R.id.name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startNewActivity();
                }
            });
        }

        private void startNewActivity() {
            Intent intent = new Intent(parent, PlanetActivityInfo.class);
            intent.putExtra("Planet", planet);
            parent.startActivity(intent);
        }

        protected void bind(Planet planet) {
            this.planet = planet;
            name.setText(planet.getName());
        }
    }
}

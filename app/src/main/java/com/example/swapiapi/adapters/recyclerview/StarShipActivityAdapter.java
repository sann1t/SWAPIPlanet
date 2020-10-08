package com.example.swapiapi.adapters.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.categoryActivity.starships.StarShipActivity;
import com.example.swapiapi.categoryActivity.starships.StarShipActivityInfo;
import com.example.swapiapi.models.starships.StarShip;
import com.example.swapiapi.models.starships.StarShipsList;


import java.util.List;

public class StarShipActivityAdapter extends RecyclerView.Adapter<StarShipActivityAdapter.StarShipActivityViewHolder> {

    private Context parent;
    private List<StarShip> starShipList;

    public StarShipActivityAdapter(StarShipsList starShipsList, Context parent) {
        this.parent = parent;
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

    public class StarShipActivityViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private StarShip starShip;


        public StarShipActivityViewHolder(@NonNull View itemView) {
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
            Intent intent = new Intent(parent, StarShipActivityInfo.class);
            intent.putExtra("StarShip", starShip);
            parent.startActivity(intent);
        }

        public void bind(StarShip starShip) {
            this.starShip = starShip;

            name.setText(starShip.getName());
        }
    }
}

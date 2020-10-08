package com.example.swapiapi.adapters.recyclerview.specie;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.categoryActivity.species.SpecieActivityInfo;
import com.example.swapiapi.models.species.Specie;

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
        Intent intent = new Intent(itemView.getContext(), SpecieActivityInfo.class);
        intent.putExtra("Specie", specie);
        itemView.getContext().startActivity(intent);
    }

    public void bind(Specie specie){
        this.specie = specie;

        name.setText(specie.getName());
    }
}
package com.example.swapiapi.adapters.recyclerview.vehicle;


import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.swapiapi.R;
import com.example.swapiapi.categoryActivity.vehicles.VehicleActivityInfo;
import com.example.swapiapi.models.RandomColor;
import com.example.swapiapi.models.RandomColorInterface;
import com.example.swapiapi.models.vehicles.Vehicle;

public class VehicleActivityViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private Vehicle vehicle;
    private TextView imageName;
    private RandomColorInterface randomColorInterface;
    private GradientDrawable gradientDrawable;

    public VehicleActivityViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        imageName = itemView.findViewById(R.id.image_text);
        randomColorInterface = new RandomColor();
        gradientDrawable = (GradientDrawable) itemView.getResources().getDrawable(R.drawable.image_style);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity();
            }
        });
    }

    private void startNewActivity() {
        Intent intent = new Intent(itemView.getContext(), VehicleActivityInfo.class);
        intent.putExtra("Vehicle", vehicle);
        itemView.getContext().startActivity(intent);
    }

    public void bind(Vehicle vehicle) {
        this.vehicle = vehicle;
        imageName.setText(vehicle.getName().substring(0,1));
        gradientDrawable.setColor(randomColorInterface.getRandomColor());
        name.setText(vehicle.getName());
    }
}
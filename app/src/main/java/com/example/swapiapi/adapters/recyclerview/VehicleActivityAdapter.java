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
import com.example.swapiapi.categoryActivity.vehicles.VehicleActivityInfo;
import com.example.swapiapi.models.vehicles.Vehicle;
import com.example.swapiapi.models.vehicles.VehiclesList;

import java.util.List;

public class VehicleActivityAdapter extends RecyclerView.Adapter<VehicleActivityAdapter.VehicleActivityViewHolder> {

    private Context parent;
    private List<Vehicle> vehicleList;

    public VehicleActivityAdapter(VehiclesList vehiclesList, Context parent) {
        this.vehicleList = vehiclesList.getResults();
        this.parent = parent;
    }

    @NonNull
    @Override
    public VehicleActivityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_category_activity, viewGroup, false);

        return new VehicleActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleActivityViewHolder vehicleActivityViewHolder, int i) {
        vehicleActivityViewHolder.bind(vehicleList.get(i));
    }

    @Override
    public int getItemCount() {
        return vehicleList.size();
    }

    public class VehicleActivityViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private Vehicle vehicle;

        public VehicleActivityViewHolder(@NonNull View itemView) {
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
            Intent intent = new Intent(parent, VehicleActivityInfo.class);
            intent.putExtra("Vehicle", vehicle);
            parent.startActivity(intent);
        }

        public void bind(Vehicle vehicle) {
            this.vehicle = vehicle;
            name.setText(vehicle.getName());
        }
    }
}

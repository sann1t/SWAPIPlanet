package com.example.swapiapi.adapters.recyclerview.vehicle;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.swapiapi.R;
import com.example.swapiapi.models.vehicles.Vehicle;
import com.example.swapiapi.models.vehicles.Vehicles;
import com.example.swapiapi.views.vehicles.info.StartNewActivityCallBack;

import java.util.List;

public class VehicleActivityAdapter extends RecyclerView.Adapter<VehicleActivityViewHolder> {

    private List<Vehicle> vehicleList;
    private StartNewActivityCallBack callBack;

    public VehicleActivityAdapter(Vehicles vehicles, StartNewActivityCallBack callBack) {
        this.callBack = callBack;
        this.vehicleList = vehicles.getResults();
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
        vehicleActivityViewHolder.bind(vehicleList.get(i), callBack);
    }

    @Override
    public int getItemCount() {
        return vehicleList.size();
    }

}

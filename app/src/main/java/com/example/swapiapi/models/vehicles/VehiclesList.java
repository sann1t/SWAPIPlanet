package com.example.swapiapi.models.vehicles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class VehiclesList implements Serializable {

    @SerializedName("results")
    @Expose
    private List<Vehicle> results;

    public List<Vehicle> getResults() {
        return results;
    }

    public void setResults(List<Vehicle> results) {
        this.results = results;
    }
}

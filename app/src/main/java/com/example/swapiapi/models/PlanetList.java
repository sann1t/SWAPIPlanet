package com.example.swapiapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlanetList {

    @SerializedName("results")
    @Expose
    private List<Planet> results = null;

    public List<Planet> getResults() {
        return results;
    }

    public void setResults(List<Planet> results) {
        this.results = results;
    }
}

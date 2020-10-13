package com.example.swapiapi.models.planets;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Planets implements Serializable {

    @SerializedName("results")
    @Expose
    private List<Planet> results;

    public List<Planet> getResults() {
        return results;
    }

    public void setResults(List<Planet> results) {
        this.results = results;
    }
}

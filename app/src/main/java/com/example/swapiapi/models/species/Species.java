package com.example.swapiapi.models.species;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Species implements Serializable {

    @SerializedName("results")
    @Expose
    private List<Specie> results;

    public List<Specie> getResults() {
        return results;
    }

    public void setResults(List<Specie> results) {
        this.results = results;
    }
}

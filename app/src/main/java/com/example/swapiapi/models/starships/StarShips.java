package com.example.swapiapi.models.starships;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class StarShips implements Serializable {

    @SerializedName("results")
    @Expose
    private List<StarShip> results;

    public List<StarShip> getResults() {
        return results;
    }

    public void setResults(List<StarShip> results) {
        this.results = results;
    }
}

package com.example.swapiapi.models.peoples;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PeoplesList implements Serializable {

    @SerializedName("results")
    @Expose
    private List<People> results;

    public List<People> getResults() {
        return results;
    }

    public void setResults(List<People> results) {
        this.results = results;
    }
}

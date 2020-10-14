package com.example.swapiapi.models.films;

import java.io.Serializable;
import java.util.List;

public class Films implements Serializable {

    private List<Film> results;

    public List<Film> getResults() {
        return results;
    }

    public void setResult(List<Film> result) {
        this.results = result;
    }
}

package com.example.swapiapi.network;

import com.example.swapiapi.models.PlanetList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SwapiApi {

    @GET("planets/")
    Call<PlanetList> getListPlanets();
}

package com.example.swapiapi.network;

import com.example.swapiapi.models.films.Films;
import com.example.swapiapi.models.peoples.Peoples;
import com.example.swapiapi.models.planets.Planets;
import com.example.swapiapi.models.species.Species;
import com.example.swapiapi.models.starships.StarShips;
import com.example.swapiapi.models.vehicles.Vehicles;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SwapiApi {

    @GET("planets/")
    Call<Planets> getPlanetsList();

    @GET("people/")
    Call<Peoples> getPeoplesList();

    @GET("vehicles/")
    Call<Vehicles> getVehiclesList();

    @GET("starships/")
    Call<StarShips> getStarShipsList();

    @GET("species/")
    Call<Species> getSpeciesList();

    @GET("films/")
    Call<Films> getFilmsList();

}

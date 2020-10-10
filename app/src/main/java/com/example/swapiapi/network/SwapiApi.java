package com.example.swapiapi.network;

import com.example.swapiapi.models.films.FilmsList;
import com.example.swapiapi.models.peoples.PeoplesList;
import com.example.swapiapi.models.planets.PlanetsList;
import com.example.swapiapi.models.species.SpeciesList;
import com.example.swapiapi.models.starships.StarShipsList;
import com.example.swapiapi.models.vehicles.VehiclesList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SwapiApi {

    @GET("planets/")
    Call<PlanetsList> getPlanetsList();

    @GET("people/")
    Call<PeoplesList> getPeoplesList();

    @GET("vehicles/")
    Call<VehiclesList> getVehiclesList();

    @GET("starships/")
    Call<StarShipsList> getStarShipsList();

    @GET("species/")
    Call<SpeciesList> getSpeciesList();

    @GET("films/")
    Call<FilmsList> getFilmsList();

}

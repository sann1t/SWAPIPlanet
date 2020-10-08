package com.example.swapiapi.models.planets;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Planet implements Serializable {


    private String name;
    private String rotation_period;
    private String orbital_period;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRotationPeriod() {
        return rotation_period;
    }

    public void setRotationPeriod(String rotationPeriod) {
        this.rotation_period = rotationPeriod;
    }

    public String getOrbitalPeriod() {
        return orbital_period;
    }

    public void setOrbitalPeriod(String orbitalPeriod) {
        this.orbital_period = orbitalPeriod;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getSurfaceWater() {
        return surface_water;
    }

    public void setSurfaceWater(String surfaceWater) {
        this.surface_water = surfaceWater;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }


}

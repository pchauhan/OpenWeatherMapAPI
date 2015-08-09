package com.sn.owweather.OWWeatherAPI.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * Created by parag.chauhan on 8/4/2015.
 */
public class City_Object {
    public int id,population ;
    public String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Coord_Object getCoordObject() {
        return coordObject;
    }

    public void setCoordObject(Coord_Object coordObject) {
        this.coordObject = coordObject;
    }

    public Sys_Object getSysObject() {
        return sysObject;
    }

    public void setSysObject(Sys_Object sysObject) {
        this.sysObject = sysObject;
    }

    public String name ;

    @SerializedName("coord")
    public Coord_Object coordObject ;

    @SerializedName("sys")
    public Sys_Object sysObject ;
}

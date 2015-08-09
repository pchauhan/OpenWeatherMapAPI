package com.sn.owweather.OWWeatherAPI.Objects;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by parag.chauhan on 8/4/2015.
 */
public class Weather_Response_Object {
    @SerializedName("coord")
    public Coord_Object coordObject ;

    @SerializedName("weather")
    public ArrayList<Weather_Object> arrWeatherObject ;

    public String base ,name;

    public float getVisibility() {
        return visibility;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    public Coord_Object getCoordObject() {
        return coordObject;
    }

    public void setCoordObject(Coord_Object coordObject) {
        this.coordObject = coordObject;
    }

    public ArrayList<Weather_Object> getArrWeatherObject() {
        return arrWeatherObject;
    }

    public void setArrWeatherObject(ArrayList<Weather_Object> arrWeatherObject) {
        this.arrWeatherObject = arrWeatherObject;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDt() {
        return dt;
    }

    public void setDt(float dt) {
        this.dt = dt;
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public float getCod() {
        return cod;
    }

    public void setCod(float cod) {
        this.cod = cod;
    }

    public Wind_Object getWindObject() {
        return windObject;
    }

    public void setWindObject(Wind_Object windObject) {
        this.windObject = windObject;
    }

    public Clouds_Object getCloudsObject() {
        return cloudsObject;
    }

    public void setCloudsObject(Clouds_Object cloudsObject) {
        this.cloudsObject = cloudsObject;
    }

    public Sys_Object getSysObject() {
        return sysObject;
    }

    public void setSysObject(Sys_Object sysObject) {
        this.sysObject = sysObject;
    }

    public float visibility ,dt,id,cod ;

    @SerializedName("wind")
    public Wind_Object windObject ;

    @SerializedName("clouds")
    public Clouds_Object cloudsObject ;

    @SerializedName("sys")
    public Sys_Object sysObject ;



}

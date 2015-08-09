package com.sn.owmapapimanager.Objects;

/**
 * Created by parag.chauhan on 8/4/2015.
 */
public class Sys_Object {
    public float type;
    public float id;

    public float getType() {
        return type;
    }

    public void setType(float type) {
        this.type = type;
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public float getSunrise() {
        return sunrise;
    }

    public void setSunrise(float sunrise) {
        this.sunrise = sunrise;
    }

    public float getSunset() {
        return sunset;
    }

    public void setSunset(float sunset) {
        this.sunset = sunset;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float message;
    public float sunrise;
    public float sunset ;
    public String   country;

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public String pod;
}

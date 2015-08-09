package com.sn.owweather.OWWeatherAPI.Objects;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parag.chauhan on 8/4/2015.
 */
public class List_Object {

    public float dt;
    public String dt_txt;
    public float pressure ,humidity,speed,deg;



    @SerializedName("temp")
    public Temp_Object tempObject ;

    @SerializedName("weather")
    public ArrayList<Weather_Object> arrWeather ;

    @SerializedName("main")
    public Main_Object mainObject ;



    @SerializedName("wind")
    public Wind_Object windObject;

    @SerializedName("sys")
    public Sys_Object sysObject;




    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getDeg() {
        return deg;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }





    public Temp_Object getTempObject() {
        return tempObject;
    }

    public void setTempObject(Temp_Object tempObject) {
        this.tempObject = tempObject;
    }
    public float getDt() {
        return dt;
    }

    public void setDt(float dt) {
        this.dt = dt;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
    public ArrayList<Weather_Object> getArrWeather() {
        return arrWeather;
    }

    public void setArrWeather(ArrayList<Weather_Object> arrWeather) {
        this.arrWeather = arrWeather;
    }
    public Main_Object getMainObject() {
        return mainObject;
    }

    public void setMainObject(Main_Object mainObject) {
        this.mainObject = mainObject;
    }





    public Wind_Object getWindObject() {
        return windObject;
    }

    public void setWindObject(Wind_Object windObject) {
        this.windObject = windObject;
    }

    public Sys_Object getSysObject() {
        return sysObject;
    }

    public void setSysObject(Sys_Object sysObject) {
        this.sysObject = sysObject;
    }






}

package com.sn.owweather.OWWeatherAPI.Objects;

/**
 * Created by parag.chauhan on 8/4/2015.
 */
public class Main_Object {
    /*"temp": 287.32,
            "temp_min": 287.32,
            "temp_max": 288.142,
            "pressure": 990.62,
            "sea_level": 1024.14,
            "grnd_level": 990.62,
            "humidity": 82,
            "temp_kf": -0.82*/
    public float temp;
    public float pressure;
    public float humidity;
    public float temp_min;
    public float sea_level;
    public float grnd_level;
    public float temp_kf;
    public float temp_max;


    public float getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(float grnd_level) {
        this.grnd_level = grnd_level;
    }

    public float getTemp_kf() {
        return temp_kf;
    }

    public void setTemp_kf(float temp_kf) {
        this.temp_kf = temp_kf;
    }

    public float getSea_level() {

        return sea_level;
    }

    public void setSea_level(float sea_level) {
        this.sea_level = sea_level;
    }


    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

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

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }
}

package com.sn.owweather.OWWeatherAPI.Objects;

/**
 * Created by parag.chauhan on 8/4/2015.
 */
public class Weather_Object {
   public int  id ;
   public String main;
    public String description;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String icon ;
}

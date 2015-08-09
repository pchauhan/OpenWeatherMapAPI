package com.sn.owmapapimanager.Objects;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by parag.chauhan on 8/4/2015.
 */
public class Forcast_Response_Object {
    @SerializedName("city")
    public City_Object cityObject ;
    public String cod ;
    public int cnt;
    public float message ;
    @SerializedName("list")
    public ArrayList<List_Object> arrList ;

    public City_Object getCityObject() {
        return cityObject;
    }

    public void setCityObject(City_Object cityObject) {
        this.cityObject = cityObject;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    /*public ArrayList<List_Object> getArrList() {
        return arrList;
    }

    public void setArrList(ArrayList<List_Object> arrList) {
        this.arrList = arrList;
    }*/
}

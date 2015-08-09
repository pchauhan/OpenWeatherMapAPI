package com.sn.owmapapimanager;

import android.app.Activity;

import com.loopj.android.http.RequestParams;
import com.sn.owmapapimanager.NetworkRequest.Request_AsynchTask;
import com.sn.owmapapimanager.NetworkRequest.Response_Interface;
import com.sn.owmapapimanager.NetworkRequest.Urls;

/**
 * Created by parag.chauhan on 8/7/2015.
 */
public class RequestAPI {

    public static void getWeather(Activity activity , RequestParams requestParams,Response_Interface responseInterface ,boolean isProgress){
        Request_AsynchTask reqWeather = new Request_AsynchTask(activity, Urls.weather_Url, requestParams, responseInterface, isProgress);
    }
    public static void getForcastFor16days(Activity activity , RequestParams requestParams,Response_Interface responseInterface ,boolean isProgress){
        Request_AsynchTask reqForcast16 = new Request_AsynchTask(activity, Urls.forecast16_Url, requestParams, responseInterface, isProgress);
    }
    public static void getForcastFor5days(Activity activity , RequestParams requestParams,Response_Interface responseInterface ,boolean isProgress){
        Request_AsynchTask reqForcast5 = new Request_AsynchTask(activity, Urls.forecast5_Url, requestParams, responseInterface, isProgress);
    }

}

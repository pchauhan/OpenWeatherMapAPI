package com.sn.owweather;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.GsonBuilder;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.loopj.android.http.RequestParams;
import com.sn.owmapapimanager.Constant.OWWeather_API_Constant;
import com.sn.owmapapimanager.NetworkRequest.Response_Interface;
import com.sn.owmapapimanager.NetworkRequest.Response_Object;
import com.sn.owmapapimanager.Objects.Forcast_Response_Object;
import com.sn.owmapapimanager.Objects.Weather_Response_Object;
import com.sn.owmapapimanager.RequestAPI;


public class MainActivity extends AppCompatActivity implements Response_Interface, ConnectionCallbacks,
        OnConnectionFailedListener, LocationListener {
    private static final String TAG = "LocationActivity";
    private static final long INTERVAL = 1000 * 10;
    private static final long FASTEST_INTERVAL = 1000 * 5;

    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    Location mCurrentLocation;
    boolean isLocationAvailable = true;

    TextView tvResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!isGooglePlayServicesAvailable()) {
            finish();
        }
        createLocationRequest();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        tvResponse = (TextView) findViewById(R.id.tvResponse);
     /* RequestParams requestParams = new RequestParams();
        requestParams.put(OWWeather_API_Constant.Q, "London,uk");
        RequestAPI.getWeather(this,requestParams,this,true);*/

       /*//By city name
        RequestParams requestParams = new RequestParams();
        requestParams.put(OWWeather_API_Constant.Q, "London,uk");
        RequestAPI.getWeather(this,requestParams,this,true);*/

        //By city id
       /* RequestParams requestParams = new RequestParams();
          requestParams.put(OWWeather_API_Constant.ID, "2172797");
          RequestAPI.getWeather(this,requestParams,this,true);

        //By geographic coordinates
      /*RequestParams requestParams = new RequestParams();
        requestParams.put(OWWeather_API_Constant.LATITUDE, mCurrentLocation.getLatitude());
        requestParams.put(OWWeather_API_Constant.LONGITUDE, mCurrentLocation.getLongitude());
        RequestAPI.getWeather(this,requestParams,this,true);*/


        /*//By Zip Code
        //zip={zip code},{country code}
        RequestParams requestParams = new RequestParams();
        requestParams.put(OWWeather_API_Constant.ZIP,"94040,us");
        RequestAPI.getWeather(this,requestParams,this,true);*/

        //Forecast 16
        //Call 16 day / daily forecast data

        //By city name
      /*RequestParams requestParams = new RequestParams();
        requestParams.put(OWWeather_API_Constant.Q,"London");
        RequestAPI.getForcastFor16days(this, requestParams, this, true);*/
       /* //By city Id
        RequestParams requestParams = new RequestParams();
        requestParams.put(OWWeather_API_Constant.ID,"524901");
        RequestAPI.getForcastFor16days(this, requestParams, this, true) ;
*/
        //By geographic coordinats
    /*  RequestParams requestParams = new RequestParams();
        requestParams.put(OWWeather_API_Constant.LATITUDE, mCurrentLocation.getLatitude());
        requestParams.put(OWWeather_API_Constant.LONGITUDE, mCurrentLocation.getLongitude());
        RequestAPI.getForcastFor16days(this, requestParams, this, true);
*/

        //Forecast 5
        //Call 5 day / 3 hour forecast data

        //By city name

        RequestParams requestParams = new RequestParams();
        requestParams.put(OWWeather_API_Constant.Q, "London");
        RequestAPI.getForcastFor5days(this, requestParams, this, true);
        //By city Id
     /* RequestParams requestParams = new RequestParams();
        requestParams.put(OWWeather_API_Constant.ID,"524901");
        RequestAPI.getForcastFor5days(this, requestParams, this, true);
     */   //By geographic coordinats
      /*RequestParams requestParams = new RequestParams();
        requestParams.put(OWWeather_API_Constant.LATITUDE, mCurrentLocation.getLatitude());
        requestParams.put(OWWeather_API_Constant.LONGITUDE, mCurrentLocation.getLongitude());
        RequestAPI.getForcastFor5days(this, requestParams, this, true);
 */
    }

    private boolean isGooglePlayServicesAvailable() {
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (ConnectionResult.SUCCESS == status) {
            return true;
        } else {
            GooglePlayServicesUtil.getErrorDialog(status, this, 0).show();
            return false;
        }
    }

    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mGoogleApiClient.isConnected()) {
            startLocationUpdates();
            Log.d(TAG, "Location update resumed .....................");
        }

    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = "
                + result.getErrorCode());
    }

    @Override
    public void onConnected(Bundle arg0) {
        // Once connected with google api, get the location
        startLocationUpdates();
    }

    protected void startLocationUpdates() {
        PendingResult<Status> pendingResult = LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient, mLocationRequest, this);
        Log.d(TAG, "Location update started ..............: ");
    }

    @Override
    public void onConnectionSuspended(int arg0) {
        mGoogleApiClient.connect();
    }

    /**
     * Method to verify google play services on the device
     */
    @Override
    public void onLocationChanged(Location location) {
        // Assign the new location
        /*Toast.makeText(getApplicationContext(), "Location changed!",
                Toast.LENGTH_SHORT).show();*/
        mCurrentLocation = location;
        if (mCurrentLocation != null) {
            if (isLocationAvailable) {
                isLocationAvailable = false;

              /*  RequestParams requestParams = new RequestParams();
                requestParams.put(OWWeather_API_Constant.LATITUDE, mCurrentLocation.getLatitude());
                requestParams.put(OWWeather_API_Constant.LONGITUDE, mCurrentLocation.getLongitude());
                Request_AsynchTask reqWeather_By_Geographic = new Request_AsynchTask(MainActivity.this, WebUrls.forecast16_Url, requestParams, this, true);
*/
               /* RequestParams requestParams = new RequestParams();
                requestParams.put(OWWeather_API_Constant.LATITUDE, mCurrentLocation.getLatitude());
                requestParams.put(OWWeather_API_Constant.LONGITUDE, mCurrentLocation.getLongitude());
                Request_AsynchTask reqWeather_By_Geographic = new Request_AsynchTask(MainActivity.this, WebUrls.weather_Url, requestParams, this, true);*/

              /*  RequestParams requestParams = new RequestParams();
                requestParams.put(OWWeather_API_Constant.LATITUDE, mCurrentLocation.getLatitude());
                requestParams.put(OWWeather_API_Constant.LONGITUDE, mCurrentLocation.getLongitude());
                Request_AsynchTask reqorecast_5_By_Geographic = new Request_AsynchTask(MainActivity.this, WebUrls.forecast16_Url, requestParams, this, true);
*/
            }
        }
        // Displaying the new location on UI
    }

    @Override
    public void onCompeleteRequest(Response_Object mResponseObject) {
        if (!mResponseObject.isError) {
            Response_Object response_object = mResponseObject;
            try {
                tvResponse.setText(response_object.mJsonObject.toString());
                //For Weather
                Weather_Response_Object weatherObject = new GsonBuilder().create().fromJson(response_object.mJsonObject.toString(), Weather_Response_Object.class);
                System.out.print(weatherObject);

                //For Forcast_Response_Object
              /*Forcast_Response_Object forcastObject = new GsonBuilder().create().fromJson(response_object.mJsonObject.toString(), Forcast_Response_Object.class);
                System.out.print(forcastObject);*/

            } catch (Exception e) {
                System.out.print(e);
            }
        } else {

        }
    }
}

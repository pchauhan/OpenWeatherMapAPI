package com.sn.owmapapimanager.NetworkRequest;


import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.sn.owmapapimanager.R;


import org.apache.http.Header;
import org.json.JSONObject;

/**
 * Created by parag.chauhan on 7/16/2015.
 */
public class Request_AsynchTask {
    Context mContext;
    ProgressDialog mProgressDialog;
    boolean mIsProgShow;
    Response_Object response_Object;
    Response_Interface response_interface;

    public Request_AsynchTask(Context Context, String url, RequestParams params,Response_Interface response_Interface, boolean isProgShow) {
        this.mContext = Context;
        response_Object = new Response_Object();

        mProgressDialog = new ProgressDialog(Context);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage(this.mContext.getString(R.string.pleasewait));
        this.mIsProgShow = isProgShow;
        this.response_interface = response_Interface ;

        AsyncHttpClient client = new AsyncHttpClient();
        showDialog();
        Log.i("URL",url);
        client.get(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                System.out.print("Code=" + statusCode + "==ResponseString=" + responseString);
                response_Object.isError = true;
                response_Object.mResponse = responseString;
                hideDialog();
            }

           /* @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                response_Object.isError = true ;
                response_Object.mJsonObject = errorResponse;
                System.out.print("Code=" + statusCode + "==ResponseString=" + errorResponse);
                hideDialog();
            }*/

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                response_Object.isError = false;
                response_Object.mJsonObject = response;
                response_interface.onCompeleteRequest(response_Object);
                hideDialog();
            }


        });
    }

    public void showDialog() {
        if (mIsProgShow) {
            mProgressDialog.show();
        }
    }

    public void hideDialog() {
        if (mIsProgShow) {
            mProgressDialog.dismiss();
        }
    }

}

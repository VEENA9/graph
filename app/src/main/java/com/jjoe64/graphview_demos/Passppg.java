package com.jjoe64.graphview_demos;

import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.jjoe64.graphview_demos.app.AppController;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.os.Handler;

import static com.jjoe64.graphview_demos.app.AppController.TAG;

public class Passppg {

    private String jsonResponse;
    private TextView txtResponse;
    private ProgressDialog pDialog;
    private static double ppg;


    public static double makeJsonObjectRequest() {

        final String urlJsonObj = "http://192.168.8.105:8080/device/D1";
        final String[] jsonResponse = new String[1];
        final TextView txtResponse = null;

//        showpDialog();

//        final Handler handler = new Handler();
//        final int delay = 200; //milliseconds
//
//        handler.postDelayed(new Runnable(){
//            public void run(){

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                urlJsonObj, (String) null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {

                    double ppg = response.getDouble("ppg");
//

//
                    jsonResponse[0] += "ppg:  " + ppg + "\n\n";
//                    jsonResponse += "ppg:       " + ppg + "\n\n";

//                    txtResponse.setText(jsonResponse[0]);

                } catch (JSONException e) {
                    e.printStackTrace();
//                    Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
//                hidepDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
//                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
//                hidepDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);

//                handler.postDelayed(this, delay);
//            }
//        }, delay);

        return ppg;
    }

    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
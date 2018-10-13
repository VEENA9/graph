package com.jjoe64.graphview_demos;

import android.app.ProgressDialog;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.jjoe64.graphview_demos.app.AppController;

import org.json.JSONException;
import org.json.JSONObject;

import static com.jjoe64.graphview_demos.app.AppController.TAG;

public class Passtemp {

    private static double tempareture;
    private String urlJsonObj = "http://192.168.8.105:8080/history/temp/D1";
    private String jsonResponse;
    private TextView txtResponse;
    private ProgressDialog pDialog;

    public static double makeJsonObjectRequest() {

        final String urlJsonObj = "http://192.168.8.105:8080/history/temp/D1";
        final String[] jsonResponse = new String[1];
        final TextView txtResponse = null;

//        showpDialog();
//       final Handler handler = new Handler();
//        final int delay = 5000; //milliseconds
//
//        handler.postDelayed(new Runnable(){
//            public void run(){

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.GET,
                urlJsonObj, (String) null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    // Parsing json object response
                    // response will be a json object
//
                    String tempareture = response.getString("tempareture");
//
                    jsonResponse[0] += "tempareture:  " + tempareture;
//

                    txtResponse.setText(jsonResponse[0]);

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


        return tempareture;
    }

    public static double getVariable() {
//        makeJsonObjectRequest();
        return tempareture;
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
package com.jjoe64.graphview_demos.app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.jjoe64.graphview_demos.ItemDetailActivity;
import com.jjoe64.graphview_demos.ItemListActivity;
import com.jjoe64.graphview_demos.Photo4;
import com.jjoe64.graphview_demos.R;
import com.jjoe64.graphview_demos.categories.RealtimeFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class Main3Activity extends Activity {
    // json object response url
    private String urlJsonObj = "http://192.168.8.105:8080/device/D1";

    // json array response url
//    private String urlJsonArry = "https://api.androidhive.info/volley/person_array.json";

    private static String TAG = Main3Activity.class.getSimpleName();
    private Button btnMakeObjectRequest, btnMakeArrayRequest,btngo,btncam;

    // Progress dialog
    private ProgressDialog pDialog;

    private TextView txtResponse;

    // temporary string to show the parsed response
    private String jsonResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnMakeObjectRequest = (Button) findViewById(R.id.btnObjRequest);
        btngo = (Button) findViewById(R.id.button);
        btncam = (Button) findViewById(R.id.button3);
//        btnMakeArrayRequest = (Button) findViewById(R.id.btnArrayRequest);
        txtResponse = (TextView) findViewById(R.id.txtResponse);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

//
//
        final Handler handler = new Handler();
        final int delay = 200; //milliseconds

        handler.postDelayed(new Runnable(){
            public void run(){
//                do something


//
//
//        btnMakeObjectRequest.setOnClickListener(new View.OnClickListener() {
////
//            @Override
//            public void onClick(View v) {
//        // making json object request
        makeJsonObjectRequest();
//            }
//        });

//
//
                handler.postDelayed(this, delay);
            }
        }, delay);

        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                Intent i = new Intent(getApplicationContext(), ItemListActivity.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

            }
        });

        btncam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                Intent i = new Intent(getApplicationContext(), Photo4.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

            }
        });
//
//        btnMakeArrayRequest.setOnClickListener(new View.OnClickListener() {
////
//            @Override
//            public void onClick(View v) {
////                // making json array request
//////                makeJsonArrayRequest();
//            }
//        });

    }

    /**
     * Method to make json object request where json response starts wtih {
     * */
    private void makeJsonObjectRequest() {

//        showpDialog();
        //while (true);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.GET,
                urlJsonObj, (String) null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    // Parsing json object response
                    // response will be a json object
                    String tempareture = response.getString("tempareture");
                    String respirationRate = response.getString("respirationRate");
                    String heartRate = response.getString("heartRate");
                    String ppg = response.getString("ppg");
//                    String ppg = phone.getString("home");
//                    String mobile = phone.getString("mobile");
//                    String graphLastXValue = phone.getString("graphLastXValue");
//                    String graphLastYValue = phone.getString("graphLastYValue");

                    jsonResponse = "";
                    jsonResponse += "Tempareture:             " + tempareture+ "\n\n";
                    jsonResponse += "RespirationRate:       " + respirationRate + "\n\n";
                    jsonResponse += "HeartRate:                 " + heartRate + "\n\n";
//                    jsonResponse += "ppg:       " + ppg + "\n\n";
                    jsonResponse += "ppg:                     " + ppg+ "\n\n";

                    txtResponse.setText(jsonResponse);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
//                hidepDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
//                hidepDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

    /**
     * Method to make json array request where response starts with [
     * */
//    private void makeJsonArrayRequest() {
//
//        showpDialog();
//
//        JsonArrayRequest req = new JsonArrayRequest(urlJsonArry,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        Log.d(TAG, response.toString());
//
//                        try {
//                            // Parsing json array response
//                            // loop through each json object
//                            jsonResponse = "";
//                            for (int i = 0; i < response.length(); i++) {
//
//                                JSONObject person = (JSONObject) response
//                                        .get(i);
//
//                                String name = person.getString("name");
//                                String email = person.getString("email");
//                                JSONObject phone = person
//                                        .getJSONObject("phone");
//                                String home = phone.getString("home");
//                                String mobile = phone.getString("mobile");
//
//                                jsonResponse += "Name: " + name + "\n\n";
//                                jsonResponse += "Email: " + email + "\n\n";
//                                jsonResponse += "Home: " + home + "\n\n";
//                                jsonResponse += "Mobile: " + mobile + "\n\n\n";
//
//                            }
//
//                            txtResponse.setText(jsonResponse);
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            Toast.makeText(getApplicationContext(),
//                                    "Error: " + e.getMessage(),
//                                    Toast.LENGTH_LONG).show();
//                        }
//
//                        hidepDialog();
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d(TAG, "Error: " + error.getMessage());
//                Toast.makeText(getApplicationContext(),
//                        error.getMessage(), Toast.LENGTH_SHORT).show();
//                hidepDialog();
//            }
//        });
//
//        // Adding request to request queue
//        AppController.getInstance().addToRequestQueue(req);
//    }


    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}


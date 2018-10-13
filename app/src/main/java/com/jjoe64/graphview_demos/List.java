package com.jjoe64.graphview_demos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class List<D extends Number> extends AppCompatActivity {


    ListView listView;
        //items to show in listview

    String[] items = {"WARD 01", "WARD 02", "WARD 03", "WARD 04", "WARD 05", "WARD 06", "WARD 07", "WARD 08", "WARD 09"};


    Integer[] logo = {R.drawable.wardspml, R.drawable.wardspml, R.drawable.wardspml, R.drawable.wardspml, R.drawable.wardspml, R.drawable.wardspml, R.drawable.wardspml, R.drawable.wardspml};


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        //call the CustomAdapter constructor and pass the values you want to be shown in the listview
        CustomAdapter adapter = new CustomAdapter(List.this, items, logo);

        listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String itemValue = (String) listView.getItemAtPosition(position);

                Toast.makeText(List.this, itemValue, Toast.LENGTH_SHORT).show();

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent appInfo = new Intent(List.this, List2.class);
                startActivity(appInfo);
            }
        });


    }

    //create a seperate ArrayAdapter class for your specific layout design for the listview
    class CustomAdapter extends ArrayAdapter<String> {

        private final Context context;
        private final String[] items;
        private final Integer[] logo;

        //the constructor gets the values to be shown on the listview
        public CustomAdapter(Context context, String[] items, Integer[] logo) {
            super(context, R.layout.list1, items);
            this.context = context;
            this.items = items;
            this.logo = logo;
        }

        //getview method inflates the values given from the mainactivity on the custom design layout for listview and returns the layout with inflated values in it
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.list1, null, true);

            //initialize the textview and imageview we declared in the custom_list.xml file

            TextView title = (TextView) rowView.findViewById(R.id.text);

            ImageView image = (ImageView) rowView.findViewById(R.id.image);

            title.setText(items[position]);

            image.setImageResource(logo[position]);

            return rowView;
        }

    }}

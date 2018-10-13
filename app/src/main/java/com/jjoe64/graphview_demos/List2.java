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

import com.jjoe64.graphview_demos.app.Main3Activity;


public class List2 extends AppCompatActivity {


    ListView listView;
        //items to show in listview

    String[] items = {"MR.Praga      0001", "MR.Thiyan     0002", "MR.Pragash     0003", "Miss.Veena      0004", "Miss.Prasha      0005", "MR.Eeswaran      0006", "Miss.guruppu    0007", "Miss.Elakya    0008"};


    Integer[] logo = {R.drawable.praga, R.drawable.thiyan1, R.drawable.pragah1, R.drawable.vna1, R.drawable.prasa2, R.drawable.praga1, R.drawable.prasa1, R.drawable.vna2};


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        //call the CustomAdapter constructor and pass the values you want to be shown in the listview
        CustomAdapter adapter = new CustomAdapter(List2.this, items, logo);

        listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String itemValue = (String) listView.getItemAtPosition(position);

                Toast.makeText(List2.this, itemValue, Toast.LENGTH_SHORT).show();

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent appInfo = new Intent(List2.this, Main3Activity.class);
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

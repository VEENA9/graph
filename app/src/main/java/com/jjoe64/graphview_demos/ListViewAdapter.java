package com.jjoe64.graphview_demos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview_demos.app.Main3Activity;

import java.util.List;

/**
 * Created by Belal on 9/5/2017.
 */

public class ListViewAdapter extends ArrayAdapter<Hero> {

    //the hero list that will be displayed
    private List<Hero> heroList;
    private Button add;
    //the context object
    private Context mCtx;

    //here we are getting the herolist and context
    //so while creating the object of this adapter class we need to give herolist and context
    public ListViewAdapter(List<Hero> heroList, Context mCtx) {
        super(mCtx, R.layout.list_items, heroList);
        this.heroList = heroList;
        this.mCtx = mCtx;
    }

    static class ViewHolder {
        TextView text;
        Button btnMakeObjectRequest;
//        Button btnMakeObjectRequest;
    }

    //this method will return the list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        //creating a view with our xml layout
        View listViewItem = inflater.inflate(R.layout.list_items, null, true);

        //getting text views
        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewImageUrl = listViewItem.findViewById(R.id.textViewImageUrl);
        ViewHolder h = new ViewHolder();
//        h.btn = listViewItem.findViewById(R.id.btn);
        h.btnMakeObjectRequest = (Button) listViewItem.findViewById(R.id.btnObjRequest);
        listViewItem.setTag(h);
        //Getting the hero for the specified position
        Hero hero = heroList.get(position);

        //setting hero values to textviews
        textViewName.setText(hero.getName());
        textViewImageUrl.setText(hero.getImageUrl());


//        ViewHolder hi = (ViewHolder) listViewItem.getTag();

        h.btnMakeObjectRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mCtx.getApplicationContext(), "Please enter the name", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(mCtx.getApplicationContext(), Main3Activity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mCtx.startActivity(i);


                // DO what you want to recieve on btn click there.
            }
        });

        //returning the listitem
        return listViewItem;


    }



}

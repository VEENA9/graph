package com.jjoe64.graphview_demos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Ward extends AppCompatActivity {

    private Button view1;
    private Button view2;
    private Button view3;
    private Button view4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ward);

        view1 = (Button) findViewById(R.id.button9);
        view2 = (Button) findViewById(R.id.button10);
        view3 = (Button) findViewById(R.id.button11);
        view4 = (Button) findViewById(R.id.button12);


        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), getres.class);
                startActivity(i);

            }
        });

        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Ward 02", Toast.LENGTH_SHORT)
                        .show();
            }
        });
        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Ward 03", Toast.LENGTH_SHORT)
                        .show();
            }
        });
        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Ward 04", Toast.LENGTH_SHORT)
                        .show();
            }

        });

    }
}

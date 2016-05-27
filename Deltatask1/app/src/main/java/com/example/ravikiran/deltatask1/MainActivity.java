package com.example.ravikiran.deltatask1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int clicks=0;
    TextView counter;
    RelativeLayout layout;
    private int colour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = (TextView)findViewById(R.id.textView);

        /*if(savedInstanceState!=null){
            clicks=savedInstanceState.getInt("clicks");
            colourCode=savedInstanceState.getInt("colour");
        }*/

        SharedPreferences sharedpreference= getPreferences(Context.MODE_PRIVATE);
        clicks=sharedpreference.getInt("clicks", 0);
        colour=sharedpreference.getInt("colour",Color.WHITE);

        counter.setText(String.valueOf(clicks));
        layout=(RelativeLayout)findViewById(R.id.layout);
        layout.setBackgroundColor(colour);

    }



    public void changeColour(View view){
        clicks++;
        counter.setText(String.valueOf(clicks));
          Random random_number = new Random();
          colour = Color.argb(255, random_number.nextInt(256), random_number.nextInt(256), random_number.nextInt(256));
          layout=(RelativeLayout)findViewById(R.id.layout);
          layout.setBackgroundColor(colour);

        SharedPreferences sharedpreference= getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedpreference.edit();
        editor.putInt("clicks", clicks);
        editor.putInt("colour",colour);
        editor.commit();

    }

    /*@Override
    public void onSaveInstanceState(Bundle savedInstanceState){

        savedInstanceState.putInt("clicks", clicks);
        savedInstanceState.putInt("colour",colourCode);
    }*/


    public void reset(View view){
        clicks=0;
        counter.setText(String.valueOf(clicks));
        layout=(RelativeLayout)findViewById(R.id.layout);
        layout.setBackgroundColor(Color.WHITE);

        SharedPreferences sharedpreference= getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedpreference.edit();
        editor.putInt("clicks", clicks);
        editor.putInt("colour",Color.WHITE);
        editor.commit();

    }


}

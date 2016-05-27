package com.example.ravikiran.deltatask1_adv;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int clicks=0;
    TextView counter;
    RelativeLayout layout;
    private int colour_code=255; //the default value for white

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = (TextView)findViewById(R.id.textView);


        SharedPreferences sharedpreference= getPreferences(Context.MODE_PRIVATE);
        clicks=sharedpreference.getInt("clicks", 0);
        colour_code=sharedpreference.getInt("colour code",255);

        counter.setText(String.valueOf(clicks));
        layout=(RelativeLayout)findViewById(R.id.layout);
        int colour= Color.argb(255,colour_code,colour_code,colour_code);
        layout.setBackgroundColor(colour);

    }

    public void changeColour(View view){
        clicks++;
        if(colour_code!=0){
            colour_code-=5; //initially it was colour_code--, but the change was not noticeable then
        }
        counter.setText(String.valueOf(clicks));
        int colour = Color.argb(255,colour_code,colour_code,colour_code);
        layout=(RelativeLayout)findViewById(R.id.layout);
        layout.setBackgroundColor(colour);

        SharedPreferences sharedpreference= getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedpreference.edit();
        editor.putInt("clicks", clicks);
        editor.putInt("colour code",colour_code);
        editor.commit();

    }




    public void reset(View view){
        clicks=0;
        colour_code=255;
        counter.setText(String.valueOf(clicks));
        layout=(RelativeLayout)findViewById(R.id.layout);
        layout.setBackgroundColor(Color.WHITE);

        SharedPreferences sharedpreference= getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedpreference.edit();
        editor.putInt("clicks", clicks);
        editor.putInt("colour code",255);
        editor.commit();

    }



}

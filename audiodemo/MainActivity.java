package com.example.android.videodemo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;                 // 1. make an "empty" variable to declare it

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.scarface); // 2. this will instantiate the mp variable for later use
    }

    public void play (View v){
        mp.start();     // since the variable is already declared, it can use it however you want
    }

    public void pause (View v){
        mp.pause();
    }
}

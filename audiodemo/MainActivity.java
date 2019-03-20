package com.example.android.videodemo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // literally two lines of code
        MediaPlayer mp = MediaPlayer.create(this, R.raw.scarface); 
        // creating MediaPlayer, and linking context with the res/raw/scarface.mp3 file 
        
        mp.start();
    }
}

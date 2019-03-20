package com.example.android.videodemo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;                 // 1. make an "empty" variable to declare it
    AudioManager audioManager;     // will use this for controlling the volume
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE); // without this, it will cause error
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC); // getting the max volume for this specific device
        int currentvolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        mp = MediaPlayer.create(this, R.raw.scarface); // 2. this will instantiate the mp variable for later use
        SeekBar volumeControl = findViewById(R.id.volumeSeekBar);
        volumeControl.setMax(maxVolume); // setting the volumecontrol's max value to 100(default) to whatever maxvolume is
        volumeControl.setProgress(currentvolume); // setting the bar at where the initial volume is
        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {// setOnSeekBarChangeListener knows when user moves a seekbar and calls a method
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("seekbar change", Integer.toString(i));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { // when user touches the seekbar

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { // when user stop touching the seekbar

            }
        }); // end of the bracket

        final SeekBar scrubSeekbar = findViewById(R.id.scrubSeekbar);
        scrubSeekbar.setMax(mp.getDuration()); // setting the scrubBar's max to the total length of the audio
        scrubSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("scrubSeekbar", Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() { // this make the scrubBar to update depends on the song's played length
            @Override
            public void run() {
                scrubSeekbar.setProgress(mp.getCurrentPosition());
            }
        }, 0, 10); //10 milliseconds
    }

    public void play (View v){
        mp.start();     // since the variable is already declared, it can use it however you want
    }

    public void pause (View v){
        mp.pause();
    }
}

package com.example.android.eggtimer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar timeBar;
    TextView textView;

    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    public void timerSet(int i){
        int j = i*1000;
        new CountDownTimer((long)j, 1000){
          public void onTick(long milSecondsUntilDone){ // will be called every 1000milliseconds
            Log.i("Seconds left", String.valueOf(milSecondsUntilDone/100));
            textView.setText(String.valueOf(milSecondsUntilDone/100) + " left");
          }
          public void onFinish() {
              playSound();
          }
        }.start();
    }

    public void playSound(){
        mediaPlayer = MediaPlayer.create(this, R.raw.alarm);
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeBar = findViewById(R.id.TimerBar);
        textView = findViewById(R.id.textView);
        timeBar.setProgress(0);
        timeBar.setMax(30); // max is 20 minutes
        timeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("seekbar moved to : ", String.valueOf(i));
                //insert the time in the timer method
                timerSet(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
/*
* move slide bar to determine time
* hit "start" button to call timer method for predesignated time
* when timer is done, play sound.
* */

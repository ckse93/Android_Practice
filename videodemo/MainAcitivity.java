package com.example.android.videodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView v = findViewById(R.id.vv);
        v.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.demovideo);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(v); // linking mediacontroller to videwview v
        v.setMediaController(mc); //allowing mc to control the media
        v.start();
    }
}


// it needs demovideo.mp4 in res/raw/ directory to work properly 

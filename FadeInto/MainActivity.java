package com.example.android.layoutandanimation;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView pika1 = (ImageView) findViewById(R.id.imageViewPika1);
        ImageView pika2 = (ImageView) findViewById(R.id.imageView2);
        //pika1.setOnClickListener(this);
        //pika2.setOnClickListener(this);
    }
    private void fadehelper (ImageView v1, ImageView v2){
        v1.animate().alpha(0f).setDuration(500);
        v2.animate().alpha(1f).setDuration(500);
        v2.bringToFront();
    }
    public void fadeInto (View view){               //both pika1 and pika2 will have this as onClick method 
        ImageView pika1 = (ImageView) findViewById(R.id.imageViewPika1);
        ImageView pika2 = (ImageView) findViewById(R.id.imageView2);
        switch (view.getId()){          //once image is tapped, it gets the id and do corrosponding action.
            case R.id.imageViewPika1:
                fadehelper(pika1,pika2);
                break;
            case R.id.imageView2:
                fadehelper(pika2,pika1);
                break;
        }
    }
}

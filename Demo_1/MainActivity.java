package com.example.android.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public void onCLick (View view){       // View class is inmported from android.view.View
        Log.i("Info", "Button pressed\n"); // displaying information on "run" screen on android studio. 
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

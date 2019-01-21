package com.example.android.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public int count = 0;

    public void onCLick (View view){
        EditText mytextField = findViewById(R.id.myTextField);
        count++;
        Log.i("Info", "Button pressed for the " + count + " th time\n" + mytextField.getText()); // displaying information on "run" screen on android studio
        Toast.makeText(MainActivity.this, "Login attempt... this really doesnt do anything", Toast.LENGTH_SHORT).show(); // small grey text bubble shows up 
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

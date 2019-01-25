package com.example.android.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rand = new Random();
    int n = rand.nextInt(20) + 1;
    public void  onClick(View view){
        Log.i("n value : ", n + "\n");
        EditText input = findViewById(R.id.editText);
        int user_input_int = Integer.parseInt(input.getText().toString());
        if (user_input_int == n){
            Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT).show();
            n = rand.nextInt(20) + 1;
        }
        else if (user_input_int < n){
            Toast.makeText(this, "Go up", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Go down", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

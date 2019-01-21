package com.example.android.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int count = 0;


    public void onCLick (View view){
        EditText ID = findViewById(R.id.myTextField);
        EditText PW = findViewById(R.id.PW);
        count++;
        Log.i("Info", "Button pressed for the " + count + " th time\n"); // displaying information on "run" screen on android studio
        Log.i("ID: "+ID.getText(),"Password : " + PW.getText() + "\n");
        Toast.makeText(MainActivity.this, "Sending login info for " + ID.getText(), Toast.LENGTH_SHORT).show();
        ImageView imageView = findViewById(R.id.imageView);                         
        imageView.setImageResource(R.drawable.kitten);                              //changing the imageview image to kitten
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

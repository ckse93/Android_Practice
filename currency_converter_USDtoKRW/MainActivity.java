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

    public void onClick (View view){
        EditText numText = findViewById(R.id.numText);
        Double dollars = Double.parseDouble(numText.getText().toString());
        double converted = dollars *1100.3;
        String str_converted = String.format("%.2f", converted);
        Toast.makeText(this, dollars + "USD is " +str_converted + "KRW", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

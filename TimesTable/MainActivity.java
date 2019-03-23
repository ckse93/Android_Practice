package com.example.android.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView myListView;  // this will be accessed from multiple point, so put it out here

    public void generateValueforList (int i) {
        ArrayList<String> items = new ArrayList<>();
        for (int j = 1 ; j < 20 ; j++){
            int multiples = j*i;
            items.add(String.valueOf(multiples));
            Log.i("the value of Int List, ", items.get(j-1));
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
            myListView.setAdapter(arrayAdapter);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int startint_point = 1;
        SeekBar mySeekBar = findViewById(R.id.seekBar);
        myListView = findViewById(R.id.myListview);
        final TextView display_i = findViewById(R.id.display_i);

        mySeekBar.setMax(19);
        mySeekBar.setProgress(startint_point);
        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                display_i.setText("Showing multiples of : " + String.valueOf(i));
                generateValueforList(i);
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

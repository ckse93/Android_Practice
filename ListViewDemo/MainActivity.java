package com.example.android.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        ListView myListView = findViewById(R.id.myListView);

        final ArrayList<String > myFamily = new ArrayList<String>();
        myFamily.add("Chan");
        myFamily.add("kendra");
        myFamily.add("Bill");
        myFamily.add("Jongsuk");
        myFamily.add("yoonmo");


        ArrayAdapter<String> arrayAdpter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFamily);

        myListView.setAdapter(arrayAdpter); //this is where you connect array adapter and the listview
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                  // 1st param = the entire listview we have coming through
                                  // 2nd param = each individual item that was clicked on
                                  // int i = ith element that was clicked on
                                  // long l = dont worry about it for now
                String displayname = myFamily.get(i).toString();
                Toast.makeText(MainActivity.this, "Person Selected : " + displayname, Toast.LENGTH_SHORT).show();
            }
        });
    }
    */
        
        
        /*
        * 1. make a list of thing you want to display (ArrayList)
        * 2. make an adapter to link the arrayList and the context
        * 3. link your ListView with the arrayAdapter
        * 4. make a method for that list to what to do when clicked. 
        * */

        ListView myListView = findViewById(R.id.myListView);

        final ArrayList<String> friendList = new ArrayList<>();
        friendList.add("Jaci");
        friendList.add("Genny");
        friendList.add("WOnbin");
        friendList.add("Jeonghoon");
        friendList.add("Tom");
        friendList.add("Isai");
        friendList.add("Ashimita");
        friendList.add("Will");
        friendList.add("Cassie");
        friendList.add("Tony");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, friendList);

        myListView.setAdapter(arrayAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String DisplayName = friendList.get(i).toString();
                Toast.makeText(MainActivity.this, "Person Selected : " + DisplayName, Toast.LENGTH_SHORT).show();
            }
        });


}

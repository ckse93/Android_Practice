package com.example.android.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    CountDownTimer timer;
    android.support.v7.widget.GridLayout gridLayout;
    TextView timeTextView;
    TextView sumTextView;
    Button StartButton;
    ArrayList<Integer> answerArr = new ArrayList<Integer>();
    int locationOfCorrectAnswer;

    public void setTimer(int time){
        Log.i("setTimer : ", "called");
        int i = time *1000;
        final int time2 = time;
        //final int seconds = time - minute / 360;
        timer = new CountDownTimer((long) i, 1000) {
            @Override
            public void onTick(long milSecondsUntilDone) {
                long mins = TimeUnit.MILLISECONDS.toMinutes(milSecondsUntilDone);
                long secs = ((milSecondsUntilDone / 1000) % 60);
                String timeStr = String.valueOf(mins) + " / " + String.valueOf(secs);
                timeTextView.setText(timeStr);
            }

            @Override
            public void onFinish() {
                gridLayout.setVisibility(View.INVISIBLE);
                StartButton.setVisibility(View.VISIBLE);
            }
        };
    }

    public void startGame(View v){
        StartButton.setVisibility(View.INVISIBLE);
        gridLayout.setVisibility(View.VISIBLE);
        timer.start();
    }

    public void gameOver(View v){ // will be called when reset is pushed or when timer is done.
        gridLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = findViewById(R.id.gamegridLayout);
        sumTextView = findViewById(R.id.questionTextView);
        timeTextView = findViewById(R.id.timeDisplay);
        StartButton = findViewById(R.id.button2);
        setTimer(90);

        Random rand = new Random();
        int a = rand.nextInt(21); // from zero to 21
        int b =rand.nextInt(21);

        locationOfCorrectAnswer = rand.nextInt(4); //between 0 and 3
        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b) + " = ?");

        Button button0 = findViewById(R.id.btn1);
        Button button1 = findViewById(R.id.btn2);
        Button button2 = findViewById(R.id.btn3);
        Button button3 = findViewById(R.id.btn4);

        for (int i = 0 ; i< 4 ; i++){
            if (i == locationOfCorrectAnswer) {
                answerArr.add(a+b);
            } else {
                int wrongAnswer = rand.nextInt(41);
                while(wrongAnswer == (a+b)){
                    answerArr.add(rand.nextInt(41));
                }
                answerArr.add(wrongAnswer);
            }
        }
        button0.setText(Integer.toString(answerArr.get(0)));
        button1.setText(Integer.toString(answerArr.get(1)));
        button2.setText(Integer.toString(answerArr.get(2)));
        button3.setText(Integer.toString(answerArr.get(3 )));
    }

    public  void chooseAnswer (View v){
        if (Integer.toString(locationOfCorrectAnswer).equals(v.getTag().toString())){
            Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show();
        }
        //Log.i("Tag :" , v.getTag().toString());
    }
}

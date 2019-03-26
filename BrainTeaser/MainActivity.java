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
    TextView scoreTextView;
    Button StartButton;

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    ArrayList<Integer> answerArr = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score;
    int totaltries;

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
                String timeStr = String.valueOf(mins) + " : " + String.valueOf(secs);
                timeTextView.setText(timeStr);
            }

            @Override
            public void onFinish() {
                gameOver();
            }
        };
    }

    public void startGame(View v){
        score = 0;
        totaltries = 0;
        StartButton.setVisibility(View.INVISIBLE);
        gridLayout.setVisibility(View.VISIBLE);
        timer.start();
    }

    public void gameOver(){ // will be called when reset is pushed or when timer is done.
        gridLayout.setVisibility(View.INVISIBLE);
        StartButton.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = findViewById(R.id.gamegridLayout);
        sumTextView = findViewById(R.id.questionTextView);
        timeTextView = findViewById(R.id.timeDisplay);
        scoreTextView = findViewById(R.id.scoreCounterTextView);
        StartButton = findViewById(R.id.button2);

        button0 = findViewById(R.id.btn1);
        button1 = findViewById(R.id.btn2);
        button2 = findViewById(R.id.btn3);
        button3 = findViewById(R.id.btn4);
        setTimer(20);
        newQuestion();
    }

    public void newQuestion (){
        Random rand = new Random();
        int a = rand.nextInt(21); // from zero to 21
        int b =rand.nextInt(21);
        answerArr.clear();
        locationOfCorrectAnswer = rand.nextInt(4); //between 0 and 3
        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b) + " = ?");
        for (int i = 0 ; i< 4 ; i++){
            if (i == locationOfCorrectAnswer) {
                answerArr.add(a+b);
            } else {
                int wrongAnswer = rand.nextInt(41);
                while(wrongAnswer == (a+b)){
                    wrongAnswer = rand.nextInt(41);
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
        totaltries++;
        if (Integer.toString(locationOfCorrectAnswer).equals(v.getTag().toString())){
            Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
            score++;
        } else {
            Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show();
        }
        scoreTextView.setText(Integer.toString(score) + " / " + Integer.toString(totaltries));
        newQuestion();
        //Log.i("Tag :" , v.getTag().toString());
    }
}

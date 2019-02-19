package com.example.android.tiktactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    class ReadyPlayer {
        int [][] playerArray = new int[3][3];
        int victoryCount;
        ReadyPlayer(){
            victoryCount = 0;
        }
        public void setupPlayer(){
            victoryCount = 0;
        }
        public boolean didTheyWin(){
            if (this.playerArray[0][0] + this.playerArray[0][1]+ this.playerArray[0][2] == 3){
                victoryCount ++;
                return true;
            }
            else if (this.playerArray[1][0] + this.playerArray[1][1]+ this.playerArray[1][2] == 3){
                victoryCount++;
                return true;
            }
            else if (this.playerArray[2][0] + this.playerArray[2][1]+ this.playerArray[2][2] == 3){
                victoryCount++;
                return true;
            }
            else if (this.playerArray[0][0] + this.playerArray[1][0]+ this.playerArray[2][0] == 3){
                victoryCount++;
                return true;
            }
            else if (this.playerArray[0][1] + this.playerArray[1][1]+ this.playerArray[2][1] == 3){
                victoryCount++;
                return true;
            }
            else if (this.playerArray[0][2] + this.playerArray[1][2]+ this.playerArray[2][2] == 3){
                victoryCount++;
                return true;
            }
            else if (this.playerArray[0][0] + this.playerArray[1][1]+ this.playerArray[2][2] == 3){
                victoryCount++;
                return true;
            }
            else if (this.playerArray[0][2] + this.playerArray[1][1]+ this.playerArray[2][0] == 3){
                victoryCount++;
                return true;
            }
            else return false;
        }
        public void receivedInput(int i, int j){
            this.playerArray[i][j] = 1;
            return;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int whoseTurn;
    int [][] placeTaken = new int[3][3];
    ReadyPlayer player1 = new ReadyPlayer();
    ReadyPlayer player2 = new ReadyPlayer();
    ImageView W1 = (ImageView) findViewById(R.id.whitespace1);
    ImageView W2 = (ImageView) findViewById(R.id.whitespace2);
    ImageView W3 = (ImageView) findViewById(R.id.whitespace3);
    ImageView W4 = (ImageView) findViewById(R.id.whitespace4);
    ImageView W5 = (ImageView) findViewById(R.id.whitespace5);
    ImageView W6 = (ImageView) findViewById(R.id.whitespace6);
    ImageView W7 = (ImageView) findViewById(R.id.whitespace7);
    ImageView W8 = (ImageView) findViewById(R.id.whitespace8);
    ImageView W9 = (ImageView) findViewById(R.id.whitespace9);

    public void fadeIn(ImageView view){
        if (whoseTurn % 2 != 0) {
            view.setImageResource(R.drawable.red);
        }
        else {
            view.setImageResource(R.drawable.yellow);
        }
    }
    public void settingValues (int i, int j){
        if (whoseTurn%2!=0){
            player1.receivedInput(i,j);
            Log.i("SettingValues", String.valueOf(whoseTurn%2) + "player 1 : " + String.valueOf(i)+ ", "+String.valueOf(j) );
            whoseTurn++;
        }
        else {
            player2.receivedInput(i,j);
            Log.i("SettingValues", String.valueOf(whoseTurn%2) + "player 2 : " + String.valueOf(i)+ ", "+String.valueOf(j) );
            whoseTurn++;
        }
    }

    void onClick(View v){
        switch (v.getId()){


        }


        if (whoseTurn % 2 != 0){ // RED,player 1
        }
        else {
            player2.
        }
    }
}

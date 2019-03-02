package com.example.android.tiktactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int whose_turn = 10;
    int[] gameState = {0,0,0,0,0,0,0,0,0}; // 2 means unplayed, change it to 0 after the slot has been taken
    int [][] winningState = {{0,1,2}, {3,4,5,}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6} };
    protected boolean win(){
        for (int [] winningState : winningState){
            if(gameState[winningState[0]] == gameState[winningState[1]] &&
                    gameState[winningState[1]] == gameState[winningState[2]] &&
                    gameState[winningState[0]] != 0) {
                Toast.makeText(this, "WIN", Toast.LENGTH_SHORT).show();
                return true;
            }
            }
            return false;
        }
    public void dropIn (View v){
        ImageView counter = (ImageView) v; // this is the tapped on view variable

        String tagStr = counter.getTag().toString();
        int tagInt = Integer.parseInt(tagStr);
        if(gameState[tagInt] != 0){
            return;
        }
        else if (gameState[tagInt] == 0){
            counter.setTranslationY(-1000f); // 1000 pixels off the top of the screen
            if (whose_turn % 2 == 0) {
                counter.setImageResource(R.drawable.yellow);
                gameState[tagInt] = 2; // fill it in for player 2
            }
            else {
                counter.setImageResource(R.drawable.red);
                gameState[tagInt] = 1; // fill it in for player 1
            }
            whose_turn++;
            Log.i("whose_turn: ", "" + whose_turn );
            counter.animate().translationYBy(1000f).rotation(360f).setDuration(200);
            //someoneWon();
        }

        String arrayVal = Arrays.toString(gameState);
        Log.i("Array : ", arrayVal);
    }
    public void resetButton(View v){
        Toast.makeText(this, "I haven't programmed that path yet", Toast.LENGTH_SHORT).show();
    }

}

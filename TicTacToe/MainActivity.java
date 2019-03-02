package com.example.android.tiktactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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
    protected void someoneWon() {
        if (gameState[0] == gameState [1] && gameState[0] == gameState [2]){ // im very sure there is a better algorithm to check this, but im very lazy.
            if (gameState[0] == 1){
                Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT).show();
            }
        }
        else if (gameState[3] == gameState [4] && gameState[4] == gameState [5]){
            if (gameState[3] == 1){
                Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT).show();
            }
        }
        else if (gameState[6] == gameState [7] && gameState[7] == gameState [8]){
            if (gameState[6] == 1){
                Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT).show();
            }
        }
        else if (gameState[0] == gameState [3] && gameState[3] == gameState [6]){
            if (gameState[6] == 1){
                Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT).show();
            }
        }
        else if (gameState[1] == gameState [4] && gameState[4] == gameState [5]){
            if (gameState[1] == 1){
                Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT).show();
            }
        }
        else if (gameState[2] == gameState [5] && gameState[5] == gameState [8]){
            if (gameState[8] == 1){
                Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT).show();
            }
        }
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
        }
        
        String arrayVal = Arrays.toString(gameState);
        Log.i("Array : ", arrayVal);
        someoneWon();
    }
    public void resetButton(View v){
        Toast.makeText(this, "I haven't programmed that path yet", Toast.LENGTH_SHORT).show();
    }

}

package com.example.android.triangularorsquare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    class Number {
        int number;
        public boolean isTriangular(){ // not bool. this is not c++
            int x =1;
            int triangular = 1;
            while (triangular < number){
                x++;
                triangular +=x;
            }
            if (triangular == number){
                return true;
            }
            else {
                return false;
            }
        }
        public boolean isSquare(){
            double x = Math.sqrt((double)number);
            if(x % 1 ==0){ // testing if x is an integer
                return true;
            }
            return false;
        }
    }



    public void testNumber(View view){
        EditText input = findViewById(R.id.editTextInputNumber);
        try{
            Double inputnumber = Double.parseDouble(input.getText().toString()); // do i even need this...?

        }
        catch(NumberFormatException e){ // catch exception if no input was provided
            return;
        }
        Double inputnumber = Double.parseDouble(input.getText().toString());
        Log.i("testNumber : ","executed, value : " + inputnumber);
        Number yay = new Number();   //cannot think of a good variable name 
        yay.number = inputnumber.intValue();
        if (yay.isSquare() == true){
            Toast.makeText(this, "this number is square number!", Toast.LENGTH_SHORT).show();
        }
        else if (yay.isTriangular() == true){
            Toast.makeText(this, "this number is a triangular number!", Toast.LENGTH_SHORT).show();
        }
        else if (yay.isTriangular() == true && yay.isSquare() == true){
            Toast.makeText(this, "this number is both triangular and square number", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "this number is neither", Toast.LENGTH_SHORT).show();
        }

    }
}

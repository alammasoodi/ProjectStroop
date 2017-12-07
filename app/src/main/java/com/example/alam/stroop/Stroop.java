package com.example.alam.stroop;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;

public class Stroop extends AppCompatActivity implements View.OnClickListener {

        int score = 0;
        int count  = 0;
        HashMap<String, Integer> colors= new HashMap<>();
        //putting the strings of the hasmap to an array
        Object stringOnScreen[];

        Object colorsOnScreen[];


        TextView color;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    boolean flag = false;
    int colorText;
    String clickedColor;
    Button hideStart;
    LinearLayout startPage;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setUpGame();
             stringOnScreen= colors.keySet().toArray();
            colorsOnScreen= colors.values().toArray();
            setUpQuestion();

            //Log.d("test", "test: " + stringOnScreen[2].toString()); //trace code


        }//oncreate end


        public void setUpQuestion(){

            //set the text of the string in textview for user to see
            color.setText("" + stringOnScreen[randInt(0, 3)]);
            color.setTextColor((int) colorsOnScreen[randInt(0,3)]);
            colorText = color.getCurrentTextColor();
            if(colorText == Color.RED)
                clickedColor = "R";
            else if(colorText == Color.BLUE)
                clickedColor = "B";
            else if(colorText == Color.YELLOW)
                clickedColor = "Y";
            else if(colorText == Color.GREEN)
                clickedColor = "G";
        }





        public void setUpGame(){

            // setting up the hashmap
            colors.put("Green", Color.GREEN);
            colors.put("Blue", Color.BLUE);
            colors.put("Red", Color.RED);
            colors.put("Yellow", Color.YELLOW);
           // colors.put("Black", Color.BLACK);

            // setting up vars
            color = (TextView) findViewById(R.id.tvStroopColor);
            btn1 = (Button) findViewById(R.id.btnStroop1);
            btn2 = (Button) findViewById(R.id.btnStroop2);
            btn3 = (Button) findViewById(R.id.btnStroop3);
            btn4 = (Button) findViewById(R.id.btnStroop4);
            hideStart = (Button) findViewById(R.id.hideStartPage);
            startPage = (LinearLayout) findViewById(R.id.startPage);
            btn1.setOnClickListener(this);
            btn2.setOnClickListener(this);
            btn3.setOnClickListener(this);
            btn4.setOnClickListener(this);
            hideStart.setOnClickListener(this);

        }

        /**
         * method to get a random int
         * @param min
         * @param max
         * @return
         */
        public static int randInt(int min, int max) {

            // NOTE: Usually this should be a field rather than a method
            // variable so that it is not re-seeded every call.
            Random rand = new Random();

            // nextInt is normally exclusive of the top value,
            // so add 1 to make it inclusive
            int randomNum = rand.nextInt((max - min) + 1) + min;

            return randomNum;
        }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Stroop.this,Stroop.class);
        intent.putExtra("score",score);
        intent.putExtra("count",count);
        int id = view.getId();
        switch (id){
            case R.id.btnStroop1:
                    if(btn1.getText().toString().equals(clickedColor)){
                        startActivity(intent);
                        Toast.makeText(Stroop.this,"Correct",Toast.LENGTH_SHORT).show();

                    }
            break;
            case R.id.btnStroop2:
                flag = true;
                if(btn2.getText().toString().equals(clickedColor)){
                    startActivity(intent);
                    Toast.makeText(Stroop.this,"Correct",Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.btnStroop3:
                flag = true;
                if(btn3.getText().toString().equals(clickedColor)){
                    startActivity(intent);
                    Toast.makeText(Stroop.this,"Correct",Toast.LENGTH_SHORT).show();

                }

                break;
            case R.id.btnStroop4:
                flag = true;
                if(btn4.getText().toString().equals(clickedColor)){
                    startActivity(intent);
                    Toast.makeText(Stroop.this,"Correct",Toast.LENGTH_SHORT).show();

                }

                break;
            case R.id.hideStartPage:
                startPage.setVisibility(View.GONE);
                break;
        }
    }
}

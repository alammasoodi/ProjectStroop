package com.example.alam.stroop;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by alam on 31/10/17.
 */

public class StroopTest extends Fragment implements View.OnClickListener {


    View v;
    int score = 0;
    boolean isFlag;
    int count  = 0;
    HashMap<String, Integer> colors= new HashMap<>();
    Object stringOnScreen[];

    Object colorsOnScreen[];


    TextView color;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    TextView scoreView;
    boolean flag = false;
    int colorText;
    String clickedColor;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.stroop_fragment, container, false);
        pref = getActivity().getApplication().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();
        setUpGame(v);
        stringOnScreen= colors.keySet().toArray();
        colorsOnScreen= colors.values().toArray();
        isFlag = pref.getBoolean("flag",false);
        count = pref.getInt("count",count);
        if(isFlag)
        score = pref.getInt("score",score);
        scoreView.setText("Score:"+String.valueOf(score));
        setUpQuestion();
        return v;
    }
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





    public void setUpGame(View v){

        // setting up the hashmap
        colors.put("Green", Color.GREEN);
        colors.put("Blue", Color.BLUE);
        colors.put("Red", Color.RED);
        colors.put("Yellow", Color.YELLOW);
        // colors.put("Black", Color.BLACK);

        // setting up vars
        color = (TextView) v.findViewById(R.id.tvStroopColor);
        btn1 = (Button)v. findViewById(R.id.btnStroop1);
        btn2 = (Button)v. findViewById(R.id.btnStroop2);
        btn3 = (Button) v.findViewById(R.id.btnStroop3);
        btn4 = (Button) v. findViewById(R.id.btnStroop4);
        scoreView = (TextView) v.findViewById(R.id.score);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);


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
        int id = view.getId();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        final Intent intent = new Intent(getActivity(),Result.class);
        switch (id){

            case R.id.btnStroop1:
                editor.putBoolean("flag",true);
                count = count+1;
                editor.putInt("count",count);
                editor.commit();
                if (btn1.getText().toString().equals(clickedColor)) {
                    score = score + 1;
                    editor.putInt("score", score);
                    editor.commit();

                }
                if(count == 5){

                    if(btn4.getText().toString().equals(clickedColor))
                        score = score + 1;
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity(), R.style.Theme_AppCompat_Light_Dialog_Alert);
                    alertDialogBuilder.setTitle("Your Score");
                    alertDialogBuilder.setMessage(String.valueOf(score)+"/5");

                    alertDialogBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(intent);

                        }
                    });
                    alertDialogBuilder.setCancelable(false);
                    alertDialogBuilder.show().getWindow();

                }
                else {
                    fragmentManager.beginTransaction().replace(R.id.frame_layout, new StroopTest()).commit();


                }
                break;
            case R.id.btnStroop2:
                editor.putBoolean("flag",true);
                count = count+1;
                editor.putInt("count",count);
                editor.commit();
                if (btn2.getText().toString().equals(clickedColor)) {
                    score = score + 1;
                    editor.putInt("score", score);
                    editor.commit();

                }
                    if(count == 5){

                    if(btn4.getText().toString().equals(clickedColor))
                        score = score + 1;
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity(), R.style.Theme_AppCompat_Light_Dialog_Alert);
                    alertDialogBuilder.setTitle("Your Score");
                    alertDialogBuilder.setMessage(String.valueOf(score)+"/5");

                    alertDialogBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(intent);

                        }
                    });
                    alertDialogBuilder.setCancelable(false);
                    alertDialogBuilder.show().getWindow();


                }
                else {
                    fragmentManager.beginTransaction().replace(R.id.frame_layout, new StroopTest()).commit();


                }
                break;
            case R.id.btnStroop3:
                editor.putBoolean("flag",true);
                count = count+1;
                editor.putInt("count",count);
                editor.commit();
                if(btn3.getText().toString().equals(clickedColor)){
                    score = score+1;
                    editor.putInt("score",score);
                    editor.commit();

                }
                if(count == 5){

                    if(btn4.getText().toString().equals(clickedColor))
                        score = score + 1;
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity(), R.style.Theme_AppCompat_Light_Dialog_Alert);
                    alertDialogBuilder.setTitle("Your Score");
                    alertDialogBuilder.setMessage(String.valueOf(score)+"/5");

                    alertDialogBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(intent);

                        }
                    });
                    alertDialogBuilder.setCancelable(false);
                    alertDialogBuilder.show().getWindow();


                }
                else {
                    fragmentManager.beginTransaction().replace(R.id.frame_layout, new StroopTest()).commit();

                    }

                break;
            case R.id.btnStroop4:
                editor.putBoolean("flag",true);
                count = count+1;
                editor.putInt("count",count);
                editor.commit();
                if(btn4.getText().toString().equals(clickedColor)) {
                    score = score + 1;
                    editor.putInt("score", score);
                    editor.commit();
                }
                editor.commit();
                if(count == 5){
                    if(btn4.getText().toString().equals(clickedColor))
                        score = score + 1;
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity(), R.style.Theme_AppCompat_Light_Dialog_Alert);
                    alertDialogBuilder.setTitle("Your Score");
                    alertDialogBuilder.setMessage(String.valueOf(score)+"/5");

                    alertDialogBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(intent);

                        }
                    });
                    alertDialogBuilder.setCancelable(false);
                    alertDialogBuilder.show().getWindow();

                }
                else {
                    fragmentManager.beginTransaction().replace(R.id.frame_layout, new StroopTest()).commit();


                }

                break;


        }
    }
}

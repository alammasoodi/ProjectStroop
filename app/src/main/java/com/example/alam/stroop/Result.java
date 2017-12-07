package com.example.alam.stroop;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;

public class Result extends AppCompatActivity {
    TextView again;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        pref = getApplication().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();
        Intent intent = getIntent();
        int score = intent.getIntExtra("score",0);
        again = (TextView) findViewById(R.id.again);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Result.this,Start.class);
                startActivity(intent);
            }
        });

    }
}

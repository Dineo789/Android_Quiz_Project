package com.dineo.quizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainScreenActivity extends AppCompatActivity {
    Button android,xml,java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        android = (Button)findViewById(R.id.btn_act1);
        xml = (Button)findViewById(R.id.btn_act2);
        java = (Button)findViewById(R.id.btn_act3);
    }

    public void onClick(View v){
        if(v.getId() == android.getId()){
            Intent i = new Intent(this,Topic_1.class);
            startActivity(i);
        }
        if(v.getId() == xml.getId()){
            Intent i = new Intent(this,Topic_2.class);
            startActivity(i);
        } if(v.getId() == java.getId()){
            Intent i = new Intent(this,Topic_3.class);
            startActivity(i);
        }
    }
}

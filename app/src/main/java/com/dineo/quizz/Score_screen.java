package com.dineo.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Codetribe on 2016/10/18.
 */

public class Score_screen  extends AppCompatActivity{

    TextView score_txt,rating,calc_txt;
    int startScore=0;
    int score_perc;
    int score ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_screen);

        score_txt = (TextView)findViewById(R.id.myscore);
        calc_txt = (TextView)findViewById(R.id.calc_txt);
        Intent i = getIntent();
        String score_str = i.getStringExtra("USER_SCORE");
       // int score_str = i.getIntExtra("USER_SCORE");

        score = Integer.parseInt(score_str);


        //Toast.makeText(Score_screen.this,""+score,Toast.LENGTH_LONG).show();
        score_perc  = (score*100)/5;
        score_txt.setVisibility(View.INVISIBLE);




        new Thread(new Runnable (){

            @Override
            public void run()
            {
                while(startScore < score_perc)
                {
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    score_txt.post(new Runnable()
                    {
                        @Override
                        public void run() {
                            calc_txt.setVisibility(View.INVISIBLE);
                            score_txt.setVisibility(View.VISIBLE);
                            score_txt.setText(""+score_perc+ "%");

                        }
                    });
                    startScore += 1;
                }
            }
        }).start();

        if(score_perc <= 49){

              Toast.makeText(Score_screen.this,"Try Again",Toast.LENGTH_LONG).show();
        }else if(score_perc==50){

            Toast.makeText(Score_screen.this,"Good",Toast.LENGTH_LONG).show();
        }else if(score_perc<=60){

            Toast.makeText(Score_screen.this,"Very Good",Toast.LENGTH_LONG).show();
        }else{

            Toast.makeText(Score_screen.this,"Excellent",Toast.LENGTH_LONG).show();
        }



    }

}

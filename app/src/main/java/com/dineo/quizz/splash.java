package com.dineo.quizz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

/**
 * This activity contains a timer used for the splash screen
 */

public class splash extends Activity {
    ProgressBar myProgressBar;
    public static int splash_timer = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        myProgressBar = (ProgressBar)findViewById(R.id.progress_bar);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progress();
                Intent i = new Intent(splash.this,MainScreenActivity.class);
                startActivity(i);
                finish();//closes window
            }
        },splash_timer);
    }

    private void progress(){
        for(int progress = 0; progress <100;progress +=5){
            try {
                Thread.sleep(100);
                myProgressBar.setProgress(progress);
            }catch (Exception e){
                e.printStackTrace();

            }
        }

    }
}

package com.dineo.quizz;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Codetribe on 2016/10/14.
 */

public class Topic_1 extends AppCompatActivity {

    String[] Questions = new String[5];
    String[] answers = new String[15];
    String[] androidQs;
    int score = 0;
    int count = 0;
    int control = 0;//controls button click
    int question_num = 1;
    TextView question_txt, optionA_txt, optionB_txt, optionC_txt, score_txt, heading_txt;
    Button submit_btn;
    ImageButton undo_btn;
    //Resources res =getResources();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_1);

        heading_txt = (TextView) findViewById(R.id.heading);
        question_txt = (TextView) findViewById(R.id.txt2);
        score_txt = (TextView) findViewById(R.id.sxt1);
        score_txt.setVisibility(View.INVISIBLE);

        /*Gradient adding borders
        gd = new GradientDrawable();
        gd.setColor(0xFF00FF00);
        gd.setCornerRadius(5);
        gd.setStroke(2,0xFF000000);*/
        optionA_txt = (TextView) findViewById(R.id.optA);
        optionB_txt = (TextView) findViewById(R.id.optB);
        optionC_txt = (TextView) findViewById(R.id.optC);

       /* optionA_txt.setBackgroundColor(Color.WHITE);
        optionB_txt.setBackgroundColor(Color.WHITE);
        optionC_txt.setBackgroundColor(Color.WHITE);*/


        submit_btn = (Button) findViewById(R.id.btn1);
        submit_btn.setEnabled(false);
        undo_btn = (ImageButton) findViewById(R.id.undo_btn);
        undo_btn.setVisibility(View.INVISIBLE);

        //THIS BUTTON BELOW

        Questions[0] = getResources().getString(R.string.aQuestion_1);
        Questions[1] = getResources().getString(R.string.aQuestion_2);
        Questions[2] = getResources().getString(R.string.aQuestion_3);
        Questions[3] = getResources().getString(R.string.aQuestion_4);
        Questions[4] = getResources().getString(R.string.aQuestion_5);

        answers[0] = getResources().getString(R.string.aAnswer_1);
        answers[1] = getResources().getString(R.string.aAnswer_2);
        answers[2] = getResources().getString(R.string.aAnswer_3);
        answers[3] = getResources().getString(R.string.aAnswer_4);
        answers[4] = getResources().getString(R.string.aAnswer_5);
        answers[5] = getResources().getString(R.string.aAnswer_6);
        answers[6] = getResources().getString(R.string.aAnswer_7);
        answers[7] = getResources().getString(R.string.aAnswer_8);
        answers[8] = getResources().getString(R.string.aAnswer_9);
        answers[9] = getResources().getString(R.string.aAnswer_10);
        answers[10] = getResources().getString(R.string.aAnswer_11);
        answers[11] = getResources().getString(R.string.aAnswer_12);
        answers[12] = getResources().getString(R.string.aAnswer_13);
        answers[13] = getResources().getString(R.string.aAnswer_14);
        answers[14] = getResources().getString(R.string.aAnswer_15);

        heading_txt.setText("Question " + question_num);
        question_txt.setText(Questions[0]);
        optionA_txt.setText(answers[0]);
        optionB_txt.setText(answers[1]);
        optionC_txt.setText(answers[2]);

        //Resources res =getResources();
        // androidQs = res.getStringArray(R.array.Android_Questions);


    }

    public void initializeViews() {
        submit_btn.setEnabled(false);
        undo_btn.setVisibility(View.INVISIBLE);
        optionA_txt.setBackgroundColor(getResources().getColor(R.color.options));
        optionB_txt.setBackgroundColor(getResources().getColor(R.color.options));
        optionC_txt.setBackgroundColor(getResources().getColor(R.color.options));
        optionA_txt.setClickable(true);
        optionB_txt.setClickable(true);
        optionC_txt.setClickable(true);

    }

    public void onClick(View v) {

        initializeViews();


        if (control <= 3) {
            count = readArray();
            question_txt.setText(Questions[count]);
            //question 1- 5
            switch (count) {
            /*case 0:
                optionA_txt.setText(answers[0]);
                optionB_txt.setText(answers[1]);
                optionC_txt.setText(answers[2]);
                break;*/
                case 1:
                    optionA_txt.setText(answers[3]);
                    optionB_txt.setText(answers[4]);
                    optionC_txt.setText(answers[5]);
                    break;
                case 2:
                    optionA_txt.setText(answers[6]);
                    optionB_txt.setText(answers[7]);
                    optionC_txt.setText(answers[8]);
                    break;
                case 3:
                    optionA_txt.setText(answers[9]);
                    optionB_txt.setText(answers[10]);
                    optionC_txt.setText(answers[11]);
                    break;
                case 4:
                    optionA_txt.setText(answers[12]);
                    optionB_txt.setText(answers[13]);
                    optionC_txt.setText(answers[14]);
                    break;

            }
            control++;
            question_num++;
        } else {
            String myScore = score_txt.getText().toString();
            //int ms = Integer.parseInt(myScore);
            Intent i = new Intent(this, Score_screen.class);
            i.putExtra("USER_SCORE", myScore);
            startActivity(i);
            //putExtra for data
        }
        heading_txt.setText("Question " + question_num);
    }


    public int readArray() {
        if (count <= 5) {
            if (count == 0) {
                count++;
            } else if (count == 1) {
                count++;
            } else if (count == 2) {
                count++;
            } else if (count == 3) {
                count++;
            } else if (count == 4) {
                count += 0;
            }
        }
        return count;
    }

    public void undo(View v) {
        score -= 1;
        submit_btn.setEnabled(false);
        undo_btn.setVisibility(View.INVISIBLE);
        optionA_txt.setClickable(true);
        optionB_txt.setClickable(true);
        optionC_txt.setClickable(true);
    }

    public void OptionSelected(View v) {


        if (v.getId() == optionA_txt.getId()) {
            optionA_txt.setBackgroundColor(getResources().getColor(R.color.option_selected));
            optionB_txt.setBackgroundColor(getResources().getColor(R.color.options));
            optionC_txt.setBackgroundColor(getResources().getColor(R.color.options));
            selectedOption();
        } else if (v.getId() == optionB_txt.getId()) {
            optionB_txt.setBackgroundColor(getResources().getColor(R.color.option_selected));
            optionA_txt.setBackgroundColor(getResources().getColor(R.color.options));
            optionC_txt.setBackgroundColor(getResources().getColor(R.color.options));
            selectedOption();
        } else if (v.getId() == optionC_txt.getId()) {
            optionC_txt.setBackgroundColor(getResources().getColor(R.color.option_selected));
            optionA_txt.setBackgroundColor(getResources().getColor(R.color.options));
            optionB_txt.setBackgroundColor(getResources().getColor(R.color.options));
            selectedOption();

        } else {
            optionC_txt.setBackgroundColor(getResources().getColor(R.color.options));
            optionA_txt.setBackgroundColor(getResources().getColor(R.color.options));
            optionB_txt.setBackgroundColor(getResources().getColor(R.color.options));
            submit_btn.setEnabled(false);

        }

        //question 1- 5
        switch (count) {
            case 0:
                if (v.getId() == optionC_txt.getId()) {
                    score++;
                    score_txt.setText("" + score);

                } else {
                    score += 0;
                }
                break;
            case 1:
                if (v.getId() == optionA_txt.getId()) {
                    score++;
                    score_txt.setText("" + score);
                } else {
                    score += 0;
                }
                break;
            case 2:
                if (v.getId() == optionC_txt.getId()) {
                    score++;
                    score_txt.setText("" + score);
                } else {
                    score += 0;
                }
                break;
            case 3:
                if (v.getId() == optionB_txt.getId()) {
                    score++;
                    score_txt.setText("" + score);
                } else {
                    score += 0;
                }
                break;
            case 4:
                if (v.getId() == optionB_txt.getId()) {
                    score++;
                    score_txt.setText("" + score);
                } else {
                    score += 0;
                }
                break;

        }

    }

    public void selectedOption() {
        submit_btn.setEnabled(true);
        undo_btn.setVisibility(View.VISIBLE);
        optionA_txt.setClickable(false);
        optionB_txt.setClickable(false);
        optionC_txt.setClickable(false);

    }
}

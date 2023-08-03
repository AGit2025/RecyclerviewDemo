package com.example.sampleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Counter extends AppCompatActivity {
private static final long START_TIME_IN_MILLIS=60000;
private TextView textViewcount;
private Button mbuttonstartpause;
private Button mbuttonreset;
CountDownTimer countDownTimer;
private Boolean mtimerRunning;
private long TimeleftMill=START_TIME_IN_MILLIS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

          textViewcount=findViewById(R.id.tvtimes);
        mbuttonstartpause=
                findViewById(R.id.btnstartpause);
        mbuttonreset=findViewById(R.id.btnreset);

        mbuttonstartpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mtimerRunning)
                {
                    pauseTimer();
                }
                else {
                    startTimer();
                }
            }
        });
        mbuttonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });



updateCounterText();


    }
    public  void startTimer()
    {
        countDownTimer=new CountDownTimer(TimeleftMill,10000) {
            @Override
            public void onTick(long millisfinish) {
                TimeleftMill=millisfinish;
                updateCounterText();
            }

            @Override
            public void onFinish() {
           mtimerRunning=false;
           mbuttonstartpause.setText("Start");
           mbuttonstartpause.setVisibility(View.INVISIBLE);
           mbuttonreset.setVisibility(View.VISIBLE);
            }
        }.start();
        mtimerRunning=true;
        mbuttonstartpause.setText("Pause");
        mbuttonreset.setVisibility(View.INVISIBLE);
    }
    public void resetTimer()
    {
TimeleftMill=START_TIME_IN_MILLIS;
updateCounterText();
mbuttonreset.setVisibility(View.INVISIBLE);
mbuttonstartpause.setVisibility(View.VISIBLE);
    }
    public void pauseTimer()
    {countDownTimer.cancel();
        mtimerRunning=false;
        mbuttonstartpause.setText("Start");
        mbuttonreset.setVisibility(View.VISIBLE);


    }



        public void updateCounterText ()
        {
            int minutes = (int) (TimeleftMill / 1000) / 60;
            int second = (int) (TimeleftMill / 1000) % 60;
            String timeformat = String.format(Locale.getDefault(), "%02d:%02d", minutes, second);
            Log.e("TAG", "updateCounterText: "+timeformat );
         //   textViewcount.setText(timeformat);
        }



}
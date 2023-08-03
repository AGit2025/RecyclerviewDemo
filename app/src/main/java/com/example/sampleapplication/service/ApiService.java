package com.example.sampleapplication.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;



public class ApiService extends IntentService {

CountDownTimer count=null;
private String  TAG="APIService";
public static final String COUNTDOWN_BR="com.example.sampleapplication";
Intent intent=new Intent(COUNTDOWN_BR);

int i;

    public ApiService() {
        super("");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "String Timer ");

  new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {

          for( i=1;i<11;i++) {
              Toast.makeText(ApiService.this, "Got A Value: " + i, Toast.LENGTH_SHORT).show();
          }

      }
  },3000);



        count=new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long Milltime) {
                Log.i(TAG, "CountDownRemaining"+Milltime);
                intent.putExtra("countdown",Milltime);
                sendBroadcast(intent);
            }
            @Override
            public void onFinish() {
            }
        };
       count.start();
    }

    @Override
    public void onDestroy() {
        count.cancel();
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
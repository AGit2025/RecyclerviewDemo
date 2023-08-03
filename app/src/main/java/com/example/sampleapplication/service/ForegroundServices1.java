package com.example.sampleapplication.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.security.Provider;

public class ForegroundServices1 extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                {
                    Log.e("TAG", "ForeGround Service Is Running..... " );
                    try{
                        Thread.sleep(2500);
                    }
                    catch(InterruptedException e)
                    {

                    }
                }
            }
        }).start();
        final String CHANNEL_ID="Foreground Service";
        NotificationChannel channel= null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            channel = new NotificationChannel(CHANNEL_ID,CHANNEL_ID, NotificationManager.IMPORTANCE_LOW);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            getSystemService(NotificationManager.class).createNotificationChannel(channel);
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Notification.Builder notification=new Notification.Builder(this,CHANNEL_ID)
                    .setContentText("foreground Service Running")
                    .setContentTitle("This IS the Title");
            startForeground(1001,notification.build());
        }


        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

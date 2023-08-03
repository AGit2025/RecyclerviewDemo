package com.example.sampleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;

import com.example.sampleapplication.service.AiroplanChangeReceiver;
import com.example.sampleapplication.service.ForegroundServices1;

public class BroadCastReceiver extends AppCompatActivity {
    AiroplanChangeReceiver airplaneModeChangeReceiver = new AiroplanChangeReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_receiver);
        Intent serviceIntent=new Intent(this, ForegroundServices1.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(serviceIntent);
        }
        foregroundservice();
    }

    public boolean foregroundservice() {
        ActivityManager activitymanager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : activitymanager.getRunningServices(Integer.MAX_VALUE)) {
            if (ForegroundServices1.class.getName().equals(service.service.getClassName()))
         {
            return true;
        }
    }
    return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneModeChangeReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(airplaneModeChangeReceiver);
    }
}
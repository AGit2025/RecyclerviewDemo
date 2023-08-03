package com.example.sampleapplication.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AiroplanChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (isAirplaneModeOn(context.getApplicationContext())) {
            Toast.makeText(context, "AirPlane mode is on", Toast.LENGTH_SHORT).show();
        } else if (isWifiOn(context.getApplicationContext())){
            Toast.makeText(context, "WIFI  is ON", Toast.LENGTH_SHORT).show();
        } else  {
            Toast.makeText(context, "WIFI  is OFF", Toast.LENGTH_SHORT).show();
            Toast.makeText(context, "AIROPLAN is OFF", Toast.LENGTH_SHORT).show();
        }
    }
    private static boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
    private static boolean isWifiOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(),Settings.Global.WIFI_ON,1)!=0;
    }
}

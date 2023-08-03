package com.example.sampleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sampleapplication.App.IApp;
import com.example.sampleapplication.loginpresenter.Presenter;
import com.example.sampleapplication.service.ApiService;
import com.example.sampleapplication.service.MyService;
import com.example.sampleapplication.view.Userview;

public class TimerActivity extends AppCompatActivity {
  TextView txt;

String TAG="Main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
     //Null Pointer Exception
        txt=findViewById(R.id.tvtimer);
        Intent intent=new Intent(this, MyService.class);
        startService(intent);
        Log.i(TAG, "Start Services");

    }
    private BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateGUI(intent);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver,new IntentFilter(ApiService.COUNTDOWN_BR));
        Log.i(TAG, "Registerd Broacast Received");
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
        Log.i(TAG, "Registered Broad Cast Receiver");
    }

    @Override
    protected void onStop() {
        try {
            unregisterReceiver(broadcastReceiver);
        }
        catch(Exception e )
        {
            e.printStackTrace();
        }

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(this,ApiService.class));
        Log.i(TAG, "Stopped Service");
        super.onDestroy();
    }
    private void updateGUI(Intent intent)
    {
        if(intent.getExtras()!=null)
        {
            long Milltime=intent.getLongExtra("countdown",60000);
            Log.i(TAG, "CountDown Second Remaining"+Milltime/1000);
            txt.setText(Long.toString(Milltime/1000));
        }
    }
}
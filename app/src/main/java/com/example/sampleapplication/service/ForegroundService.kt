package com.example.sampleapplication.service

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.provider.SyncStateContract
import androidx.core.app.NotificationCompat
import com.example.sampleapplication.BroadCastReceiver
import com.example.sampleapplication.R

class ForegroundService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        ///val input = intent?.getStringExtra(Constants.inputExtra)
        val notificationIntent = Intent(this, BroadCastReceiver::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)


        val notification = NotificationCompat.Builder(applicationContext)
                .setContentTitle("Hii This Is Foreground Service")
              //  .setContentText(input)
                .setContentIntent(pendingIntent)
                .build()
        startForeground(1, notification)

        return START_NOT_STICKY
    }

}
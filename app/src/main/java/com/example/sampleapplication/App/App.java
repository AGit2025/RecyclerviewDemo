package com.example.sampleapplication.App;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;

import com.example.sampleapplication.database.Database1;
import com.example.sampleapplication.webservices.WebService;
import com.example.sampleapplication.webservices.WebServiesImpl;

public class App extends Application implements IApp {
private Database1 db;
private WebService webService;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @NonNull
    @Override
    public Database1 database() {
        if (db == null) db = Database1.getInstance(this);
        return db;
    }


    @NonNull
    @Override
    public WebService webService() {
        if(webService==null)webService = new WebServiesImpl();
        return webService;
    }
}
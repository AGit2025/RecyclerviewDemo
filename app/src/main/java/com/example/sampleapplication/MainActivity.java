package com.example.sampleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sampleapplication.App.IApp;
import com.example.sampleapplication.api.RetrofitClient;
import com.example.sampleapplication.loginpresenter.Presenter;
import com.example.sampleapplication.service.ApiService;
import com.example.sampleapplication.view.Userview;
import com.example.sampleapplication.webservices.Loginfetch;

import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Userview{

    Presenter presenter;
    IApp app;
    Userview userview;
    EditText etuemail,etupass;

    String TAG="Main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       app= (IApp) getApplicationContext();
        presenter=new Presenter(this,app);



        Button button=findViewById(R.id.btnlogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etuemail=findViewById(R.id.etusername);
                etupass=findViewById(R.id.etpassword);
                String  mail=etuemail.getText().toString();
                String pass=etupass.getText().toString();
                apiCall(mail,pass,"passsword");
            }
        });
        Button buttt1=findViewById(R.id.btntimer);
        buttt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RecyclerViewAniket.class));
            }
        });

    }
    public void apiCall(String username,String password, String login_type)
    {
        Loginfetch.Login.Request request = new Loginfetch.Login.Request(username,password,login_type);
        RetrofitClient.forCore().userlogin(request).enqueue(new Callback<Loginfetch.Login.Response>() {
            @Override
            public void onResponse(Call<Loginfetch.Login.Response> call, Response<Loginfetch.Login.Response> response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFailure(Call<Loginfetch.Login.Response> call, Throwable t) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Login Failed "+t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }


    @Override
    public void saveDataSuccessful(String msg) {

    }

    @Override
    public void updateDataSuccessful(String msg) {

    }

    @Override
    public void userLoginSuccessful(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void userLoginFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
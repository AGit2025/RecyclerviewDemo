package com.example.sampleapplication.loginpresenter;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.sampleapplication.App.IApp;
import com.example.sampleapplication.MainActivity;
import com.example.sampleapplication.view.Userview;
import com.example.sampleapplication.webservices.Loginfetch;
import com.example.sampleapplication.webservices.WebService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//Implementation Pending
public class Presenter implements WebService.LoginInteractor.Callback {
    private Userview userview;
    private IApp app;


    public Presenter(Userview userview, IApp app) {
        this.userview = userview;
        this.app = app;
    }


    public void getlogin(String email,String password,String logintype)
    {
        if(email.equals("aniket@bioenabletech.com")&& password.equals("1234"))
        {
            app.webService().loginInteractor().login(email,password,this);
            userview.userLoginSuccessful("Login Successful");

        }
        else {
            userview.userLoginFailed("Login Failed please try again");
        }
    }



    @Override
    public void onInvalidToken(@NonNull String q) {

    }

    @Override
    public void onNetworkError(@NonNull String q) {

    }

    @Override
    public void onUnknownError(@NonNull String q) {

    }

    @Override
    public void onNullResponse(@NonNull String q) {

    }

    @Override
    public void onSuccess(@NonNull String email, @NonNull String password) {

    }

    @Override
    public void onFail() {

    }
}

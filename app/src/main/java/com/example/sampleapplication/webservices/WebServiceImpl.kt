package com.example.sampleapplication.webservices

import android.annotation.SuppressLint
import android.util.Log
import com.example.sampleapplication.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.UnknownHostException

class WebServiesImpl : WebService {
    private var loginInteracter: WebService.LoginInteractor? = null

    override fun loginInteractor(): WebService.LoginInteractor {
        if (loginInteracter == null) loginInteracter = createlogin()
        return loginInteracter as WebService.LoginInteractor
    }


    private fun createlogin(): WebService.LoginInteractor {

        return object : WebService.LoginInteractor {

            @SuppressLint("SuspiciousIndentation")
            override fun login(emial: String, password: String, callback: WebService.LoginInteractor.Callback) {


                var request=Loginfetch.Login.Request(emial,password,"password")
                RetrofitClient.forCore().userlogin(request).enqueue(object : Callback<Loginfetch.Login.Response?> {
                    override fun onResponse(call: Call<Loginfetch.Login.Response?>, response: Response<Loginfetch.Login.Response?>) {
                        val body = response.body()
                        when(body?.resultCode) {
                            null->callback.onNullResponse(request.q)
                            0->callback.onSuccess(body.orgName,body.password)
                            1->callback.onFail()
                        }
                    }

                    override fun onFailure(call: Call<Loginfetch.Login.Response?>, t: Throwable) {
                        onCommonResponse(t,request.q+"\n${t.message}",callback)
                    }





                })


            }

        }
    }
    private fun onCommonResponse(t:Throwable,q:String,callback: WebService.CommonResponses) {
        if(t is UnknownHostException) callback.onNetworkError(q)
        else
        {
            Log.e("WebServiceImpl", "onCommonResponse: ",t )
            callback.onUnknownError(q)
        }

    }
}
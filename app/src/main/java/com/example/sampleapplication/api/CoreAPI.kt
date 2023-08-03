package com.example.sampleapplication.api


 import com.example.sampleapplication.webservices.Loginfetch
 import retrofit2.Call
 import retrofit2.http.Body
import retrofit2.http.POST

interface CoreAPI {


        companion object {
            const val API = "attendance_service.php"
        }

        @POST(API)
        fun userlogin(@Body request: Loginfetch.Login.Request) : Call<Loginfetch.Login.Response?>
  //  fun userlogin(@Body request: Loginfetch.Login.Request): retrofit2.Call<Loginfetch.Login.Response?>



    // fun userlogin1(@Body request: Loginfetch.Login.Request): Call<Loginfetch.Login.Response?>



    }

package com.example.sampleapplication.api

import com.example.sampleapplication.webservices.SerializedName

open class CommonResponse {
     @SerializedName("result_code") var resultCode : Int = -1
     @SerializedName("result") lateinit var result : String
}
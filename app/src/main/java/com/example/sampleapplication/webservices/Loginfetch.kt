package com.example.sampleapplication.webservices

import com.example.sampleapplication.api.CommonResponse


class Loginfetch {

        class Login {

            class Request(@SerializedName("username") private val username : String,
                          @SerializedName("password") private val password : String,
                          @SerializedName("login_type") private val login_type : String) {
                @SerializedName("q") val q = "login"
            }

            class Response : CommonResponse() {
                @SerializedName("user_type") lateinit var userType : String
                @SerializedName("uuid") lateinit var uuid : String
                @SerializedName("token") lateinit var token : String
                @SerializedName("logo_url") lateinit var logo_url : String
                @SerializedName("sync_token") lateinit var syncToken : String
                @SerializedName("orgid") var orgId : Int = -1
                @SerializedName("orgname") lateinit var orgName : String
                @SerializedName("sync_url") lateinit var sync_url : String
                @SerializedName("plan_id") lateinit var plan_id: String
                @SerializedName("total_reg_emp") lateinit var total_reg_emp : String
                @SerializedName("total_admin") lateinit var total_admin: String
                @SerializedName("password") lateinit var password: String
                @SerializedName("accountid") lateinit var accountid: String

            }
        }

}

annotation class SerializedName(val value: String)

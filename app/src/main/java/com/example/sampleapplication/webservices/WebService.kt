package com.example.sampleapplication.webservices

interface WebService {

    interface CommonResponses {
        fun onInvalidToken(q: String)
        fun onNetworkError(q: String)
        fun onUnknownError(q: String)
        fun onNullResponse(q: String)

    }

    interface LoginInteractor {

        interface Callback : CommonResponses {
            fun onSuccess(email: String, password: String)
            fun onFail()
        }

        fun login(emial: String, password: String, callback: Callback)


    }

    fun loginInteractor(): LoginInteractor
}
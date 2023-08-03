package com.example.sampleapplication.App

import com.example.sampleapplication.database.Database1
import com.example.sampleapplication.webservices.WebService

interface IApp {



    fun webService() : WebService

    fun database() : Database1


}
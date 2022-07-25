package com.activity.androidservicefundamental

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

//extend Service Class
class MyBackgroundService : Service() {

    init {
        Log.i(TAG,"Service has been created")
    }

    //this function call everytime client start the service
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG,"Service Started..")
        //getting data from service
        val name = intent?.getStringExtra(NAME)
        Log.i(TAG,"Data from Service is $name")
        return START_STICKY
    }

    //everytime we use service class we must implement onBind function
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        Log.i(TAG,"Service Destroyed..")
        super.onDestroy()
    }

   /* companion objects are singleton objects whose properties and functions tied
    to the class and not the instance of the class*/
    companion object{
        //constant name for the tag
        const val TAG = "My Tag"
       const val NAME = "NAME"
    }
}
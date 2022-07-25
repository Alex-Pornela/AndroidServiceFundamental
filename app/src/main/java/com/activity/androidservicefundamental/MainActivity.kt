package com.activity.androidservicefundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.activity.androidservicefundamental.MyBackgroundService.Companion.NAME
import com.activity.androidservicefundamental.MyBackgroundService.Companion.TAG
import com.activity.androidservicefundamental.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //create intent
        val serviceIntent = Intent(this,MyBackgroundService::class.java)
        //sending data from view(Activity/Fragment) to the Service
        serviceIntent.putExtra(NAME,"Alex")

        binding.apply {
            btnStart.setOnClickListener {
                //START background service
                startService(serviceIntent)
                Log.i(TAG,"Service Start")
            }

            btnStop.setOnClickListener {
                //Stop background Service
                stopService(serviceIntent)
                Log.i(TAG,"Service Stop")
            }
        }
    }
}
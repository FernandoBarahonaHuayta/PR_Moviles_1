package com.josue.apppizzeria

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View/////

class PantallaAgradecimiento : AppCompatActivity() {

    lateinit var mediaPlayer: MediaPlayer///
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_agradecimiento)

        window.statusBarColor = Color.parseColor("#E0E0E0")
        val intent = Intent(this, MusicService::class.java)
        startService(intent)
    }

    override fun onDestroy() {
        super.onDestroy()


        val intent = Intent(this, MusicService::class.java)
        stopService(intent)
    }

}
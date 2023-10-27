package com.example.aplicacionfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnLlamada : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initEvent();
    }

    private fun initEvent(){
        btnLlamada = findViewById(R.id.button);

        btnLlamada.setOnClickListener { view ->
            intent = Intent(this, Llamada::class.java)
            startActivity(intent)
        }
    }
}
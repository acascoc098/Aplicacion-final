package com.example.aplicacionfinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Llamada : AppCompatActivity() {
    private lateinit var btnVolver : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.llamada_layout)
        initEvent()
    }

    private fun initEvent(){
        btnVolver = findViewById(R.id.button5);

        btnVolver.setOnClickListener { view ->
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
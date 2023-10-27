package com.example.aplicacionfinal

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btnLlamada : Button
    private lateinit var btnURL : Button
    private lateinit var url : String
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

        btnURL = findViewById(R.id.button6)

        btnURL.setOnClickListener {
            val url = "https://www.google.com/?hl=es"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            //startActivity(intent)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }else{
                Toast.makeText( this, "No es posible lanzar la url del sitio web", Toast.LENGTH_LONG).show()
            }
        }
    }
}
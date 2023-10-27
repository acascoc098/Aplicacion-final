package com.example.aplicacionfinal

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Llamada : AppCompatActivity() {
    private lateinit var btnVolver : Button
    private lateinit var btnLlamar : Button

    companion object{
        const val NUMERO = "697105928"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.llamada_layout)
        initEvent()
    }

    private fun initEvent(){
        btnVolver = findViewById(R.id.button5)
        btnLlamar = findViewById(R.id.button4)

        //companion object {
          //  const val NUMBER = "697105928"
        //}

        btnVolver.setOnClickListener { view ->
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnVolver.setOnClickListener {
            requestPermissions()
        }
    }

    private fun requestPermissions(){
        if (Build.VERSION. SDK_INT >= Build.VERSION_CODES. M){
            if (PermissionPhone()){
                call()
            }else{
                requestPermissionLauncher.launch(android.Manifest.permission. CALL_PHONE)
            }
        }else{
            call()
        }
    }

    private fun call() {
        val intent = Intent(Intent.ACTION_CALL).apply {
            data = Uri.parse("tel:$NUMERO")
        }
        startActivity(intent)
    }

    private fun PermissionPhone(): Boolean =
        ContextCompat.checkSelfPermission( this,
            android.Manifest.permission. CALL_PHONE) == PackageManager. PERMISSION_GRANTED

    private val requestPermissionLauncher =  registerForActivityResult(
        ActivityResultContracts.RequestPermission()) {
            isGranted->
                if (isGranted) {
                    call()
                }
                else {
                    Toast.makeText( this, "Necesitas habilitar los permisos", Toast.LENGTH_LONG).show()
                }
    }
}
package com.example.examenparcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navegarMasaCorporal()
        navegarPesoIdeal()
    }
    fun navegarMasaCorporal (){
        val btnMasaCorp = findViewById<Button>(R.id.btn_Masa_Corp)
        btnMasaCorp.setOnClickListener(){
            val saltarVentanaMasaCorp: Intent = Intent(this,MasaCorporal::class.java)
            startActivity(saltarVentanaMasaCorp)
        }
    }
    fun navegarPesoIdeal (){
        val btnPesoI = findViewById<Button>(R.id.btn_Peso_Ideal)
        btnPesoI.setOnClickListener(){
            val saltarVentanaPesoI: Intent = Intent(this,PesoIdeal::class.java)
            startActivity(saltarVentanaPesoI)
        }
    }
}
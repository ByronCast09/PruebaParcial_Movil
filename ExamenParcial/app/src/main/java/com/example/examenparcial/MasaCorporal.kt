package com.example.examenparcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MasaCorporal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_masa_corporal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            WindowInsetsCompat.CONSUMED
        }
        layoutForm()
        regresarFormulario()
    }
    fun layoutForm() {
        val btn_calcu = findViewById<Button>(R.id.btn_Calcular_MasaC)
        val tv_peso = findViewById<TextView>(R.id.txt_peso)
        val tv_altura = findViewById<TextView>(R.id.txt_altura3)
        val tv_resultado = findViewById<TextView>(R.id.txt_IC)
        val tv_resultado2 = findViewById<TextView>(R.id.txt_MasaC)
        btn_calcu.setOnClickListener() {
            val peso = tv_peso.text.toString().toDouble()
            val altura = tv_altura.text.toString().toDouble()
            val imc = peso / (altura * altura)
            val mensaje = when {
                imc < 18.5 -> "Bajo peso"
                imc in 18.5..24.9 -> "Normal"
                //imc in 25 ..29.9 -> "Sobrepreso"
                else -> "Obesidad"
            }
            tv_resultado.text = "Tu IMC es: $mensaje"
            tv_resultado2.text = "${imc.toInt()}"


        }
    }
    fun regresarFormulario() {
        val btnRegres = findViewById<Button>(R.id.btn_Regresar_ICM)
        btnRegres.setOnClickListener() {
            val regresarHome: Intent = Intent(this, MainActivity::class.java)
            startActivity(regresarHome)
        }

    }
}
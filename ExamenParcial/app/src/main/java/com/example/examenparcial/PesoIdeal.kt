package com.example.examenparcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PesoIdeal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_peso_ideal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        regresarFormulario2()
        layoutForm2()
    }
    fun regresarFormulario2() {
        val btnRegres = findViewById<Button>(R.id.btn_Regresar_Pesoideal)
        btnRegres.setOnClickListener() {
            val regresarHome: Intent = Intent(this, MainActivity::class.java)
            startActivity(regresarHome)
        }

    }
    fun layoutForm2() {
        val btn_calcu = findViewById<Button>(R.id.btn_Calcular_PesoIdeal)
        val tv_sexo = findViewById<TextView>(R.id.txt_Sexo)
        val tv_altura = findViewById<TextView>(R.id.txt_Altura_PesoI)
        val tv_resultado = findViewById<TextView>(R.id.txt_PesoI)
        val tv_resultado2 = findViewById<TextView>(R.id.txt_PesoIdealAbajoCirculo)
        btn_calcu.setOnClickListener() {
            val sexo = tv_sexo.text.toString()
            val altura = tv_altura.text.toString().toDouble()
            val pesoIdeal = if (sexo == "hombre") altura - 100 else altura - 105
            tv_resultado.text = "${pesoIdeal.toInt()} kg"
            tv_resultado2.text = "Tu peso ideal es: ${pesoIdeal.toInt()} kg"
        }

    }
}
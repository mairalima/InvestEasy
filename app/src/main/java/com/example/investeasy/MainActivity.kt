package com.example.investeasy

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val btnLimpar = findViewById<Button>(R.id.btn_limpar)

        btnCalcular.setOnClickListener{
            val edtValor = findViewById<EditText>(R.id.editText_aporte)
            val edtMeses = findViewById<EditText>(R.id.editText_meses)
            val edtJuros = findViewById<EditText>(R.id.editText_juros)

            if (edtValor.text.toString().isEmpty() == true || edtMeses.text.toString().isEmpty() || edtJuros.text.toString().isEmpty() ){
                Snackbar.make(findViewById(R.id.editText_aporte), "Preencha todos os campos",Snackbar.LENGTH_LONG)
                    .show()
            } else {

                val valor = edtValor.text.toString().toDouble()
                val juros = edtJuros.text.toString().toDouble()
                val meses = edtMeses.text.toString().toInt()

                val txjuros = juros / 100
                val montante = valor * ((Math.pow(1 + txjuros, meses.toDouble()) - 1) / txjuros)

                println("Montante final: R$ %.2f".format(montante))
            }


        }



    }
}

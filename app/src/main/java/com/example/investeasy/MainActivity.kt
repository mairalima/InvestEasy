package com.example.investeasy

import android.icu.text.NumberFormat
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import java.util.Locale
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val btnLimpar = findViewById<Button>(R.id.btnClean)

        btnCalcular.setOnClickListener {
            val edtValor = findViewById<EditText>(R.id.editText_aporte)
            val edtMeses = findViewById<EditText>(R.id.editText_meses)
            val edtJuros = findViewById<EditText>(R.id.editText_juros)
            val investimento = findViewById<TextView>(R.id.text_invest)
            val renda = findViewById<TextView>(R.id.text_rend)


            if (edtValor.text.toString().isEmpty() == true || edtMeses.text.toString()
                    .isEmpty() || edtJuros.text.toString().isEmpty()
            ) {
                Snackbar.make(
                    findViewById(R.id.editText_aporte),
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {

                val aprtvalor = edtValor.text.toString().toDouble()
                val juros = edtJuros.text.toString().toDouble()
                val meses = edtMeses.text.toString().toInt()

                val txjuros = juros / 100
                val montante = aprtvalor * ((Math.pow(1 + txjuros, meses.toDouble()) - 1) / txjuros)
                val rendimento = montante - (aprtvalor * meses)

                val formato = NumberFormat.getInstance(Locale.getDefault())
                formato.minimumFractionDigits = 2
                formato.maximumFractionDigits = 2


                investimento.text = "R$ ${formato.format(montante)}"

                renda.text = "R$ ${formato.format(rendimento)}"


            }
            btnLimpar.setOnClickListener {
                edtValor.text.clear()
                edtMeses.text.clear()
                edtJuros.text.clear()
                investimento.text = ""
                renda.text = ""


            }


        }


    }

}
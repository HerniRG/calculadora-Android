package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvCuenta: TextView
    private lateinit var tvResultado: TextView
    private lateinit var btnIgual: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btn0: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btnSuma: Button
    private lateinit var btnResta: Button
    private lateinit var btnMultiplicacion: Button
    private lateinit var btnDivision: Button

    private var num1: Double = 0.0
    private var operacion: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        btnIgual.setOnClickListener { igualClick() }
        btnLimpiar.setOnClickListener { limpiarClick() }
        btn0.setOnClickListener { ceroClick() }
        btn1.setOnClickListener { unoClick() }
        btn2.setOnClickListener { dosClick() }
        btn3.setOnClickListener { tresClick() }
        btn4.setOnClickListener { cuatroClick() }
        btn5.setOnClickListener { cincoClick() }
        btn6.setOnClickListener { seisClick() }
        btn7.setOnClickListener { sieteClick() }
        btn8.setOnClickListener { ochoClick() }
        btn9.setOnClickListener { nueveClick() }
        btnSuma.setOnClickListener { sumaClick() }
        btnResta.setOnClickListener { restaClick() }
        btnMultiplicacion.setOnClickListener { multiplicacionClick() }
        btnDivision.setOnClickListener { divisionClick() }
    }

    private fun initComponents() {
        tvCuenta = findViewById(R.id.tvCuenta)
        tvResultado = findViewById(R.id.tvResultado)
        btnIgual = findViewById(R.id.btnIgual)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btn0 = findViewById(R.id.btn0)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnSuma = findViewById(R.id.btnSuma)
        btnResta = findViewById(R.id.btnMenos)
        btnMultiplicacion = findViewById(R.id.btnMultiplica)
        btnDivision = findViewById(R.id.btnDivision)
    }

    private fun igualClick() {
        if (tvCuenta.text.isNotEmpty() && operacion != null) {
            val num2 = tvCuenta.text.toString().toDouble()
            var resultado: Double = 0.0
            when (operacion) {
                "+" -> resultado = num1 + num2
                "-" -> resultado = num1 - num2
                "*" -> resultado = num1 * num2
                "/" -> {
                    if (num2 != 0.0) {
                        resultado = num1 / num2
                    } else {
                        tvResultado.text = "Error"
                        return
                    }
                }
            }

            val resultadoFormateado = String.format("%.2f", resultado)
            tvResultado.text = resultadoFormateado

            operacion = null
            limpiarClick()
        }
    }

    private fun limpiarClick() {
        tvCuenta.text = ""
        num1 = 0.0

    }

    private fun ceroClick() {
        tvCuenta.text = tvCuenta.text.toString() + "0"
    }

    private fun unoClick() {
        tvCuenta.text = tvCuenta.text.toString() + "1"
    }

    private fun dosClick() {
        tvCuenta.text = tvCuenta.text.toString() + "2"
    }

    private fun tresClick() {
        tvCuenta.text = tvCuenta.text.toString() + "3"
    }

    private fun cuatroClick() {
        tvCuenta.text = tvCuenta.text.toString() + "4"
    }

    private fun cincoClick() {
        tvCuenta.text = tvCuenta.text.toString() + "5"
    }

    private fun seisClick() {
        tvCuenta.text = tvCuenta.text.toString() + "6"
    }

    private fun sieteClick() {
        tvCuenta.text = tvCuenta.text.toString() + "7"
    }

    private fun ochoClick() {
        tvCuenta.text = tvCuenta.text.toString() + "8"
    }

    private fun nueveClick() {
        tvCuenta.text = tvCuenta.text.toString() + "9"
    }

    private fun sumaClick() {
        if (tvCuenta.text.isNotEmpty()) {
            num1 = tvCuenta.text.toString().toDouble()
            operacion = "+"
            tvCuenta.text = ""
        }
    }

    private fun restaClick() {
        if (tvCuenta.text.isNotEmpty()) {
            num1 = tvCuenta.text.toString().toDouble()
            operacion = "-"
            tvCuenta.text = ""
        }
    }

    private fun multiplicacionClick() {
        if (tvCuenta.text.isNotEmpty()) {
            num1 = tvCuenta.text.toString().toDouble()
            operacion = "*"
            tvCuenta.text = ""
        }
    }

    private fun divisionClick() {
        if (tvCuenta.text.isNotEmpty()) {
            num1 = tvCuenta.text.toString().toDouble()
            operacion = "/"
            tvCuenta.text = ""
        }
    }
}

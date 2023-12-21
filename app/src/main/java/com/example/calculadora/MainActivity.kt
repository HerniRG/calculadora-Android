package com.example.calculadora

import android.os.Bundle
import android.util.Log
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
        setOnClickListeners()
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
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion)
        btnDivision = findViewById(R.id.btnDivision)

    }

    private fun setOnClickListeners() {
        val numeros = listOf(btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)
        val operadores = listOf(btnSuma, btnResta, btnMultiplicacion, btnDivision)

        numeros.forEach { button ->
            button.setOnClickListener {
                agregarDigito(button.text.toString())
            }
        }

        operadores.forEach { button ->
            button.setOnClickListener {
                seleccionarOperacion(button.text.toString())
            }
        }

        btnIgual.setOnClickListener { igualClick() }
        btnLimpiar.setOnClickListener { limpiarClick() }
    }

    private fun agregarDigito(digito: String) {
        tvCuenta.append(digito)
    }

    private fun seleccionarOperacion(op: String) {
        if (tvCuenta.text.isNotEmpty()) {
            num1 = tvCuenta.text.toString().toDouble()
            operacion = op
            tvCuenta.text = ""
            Log.d("Calculadora", "Operación seleccionada: $operacion")
        }
    }

    private fun igualClick() {
        if (tvCuenta.text.isNotEmpty() && operacion != null) {
            val num2 = tvCuenta.text.toString().toDouble()
            Log.d("Calculadora", "num1: $num1, operacion: $operacion, num2: $num2")
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
            Log.d("Calculadora", "Operación realizada: $resultado")
        }
    }



    private fun limpiarClick() {
        tvCuenta.text = ""
        num1 = 0.0
    }
}

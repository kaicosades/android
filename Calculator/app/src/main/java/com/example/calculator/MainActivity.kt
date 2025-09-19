package com.example.calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.EditText
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var number1: EditText
    private lateinit var number2: EditText
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        result = findViewById(R.id.result)

        findViewById<Button>(R.id.btnAdd).setOnClickListener { calculate('+') }
        findViewById<Button>(R.id.btnSubtract).setOnClickListener { calculate('-') }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener { calculate('*') }
        findViewById<Button>(R.id.btnDivide).setOnClickListener { calculate('/') }
    }

    private fun calculate(op: Char) {
        val n1 = number1.text.toString().toDoubleOrNull()
        val n2 = number2.text.toString().toDoubleOrNull()

        if (n1 == null || n2 == null) {
            result.text = "Введите оба числа"
            return
        }

        val res = when(op) {
            '+' -> n1 + n2
            '-' -> n1 - n2
            '*' -> n1 * n2
            '/' -> if (n2 != 0.0) n1 / n2 else "Деление на 0"
            else -> "Ошибка"
        }
        result.text = res.toString()
    }
}

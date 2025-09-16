package com.example.homework_1

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.PI
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        val spinner: Spinner = findViewById(R.id.taskSelector)

        val tasks = listOf("Задание 1", "Задание 2", "Задание 3", "Задание 4")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tasks)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long
            ) {
                when (position) {
                    0 -> task1()
                    1 -> task2()
                    2 -> task3()
                    3 -> task4()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun task1() {
        val name: String = "Александр"
        val age: Int = 25
        val favoriteLang = "Kotlin"

        val info = """
            Имя: $name
            Возраст: $age
            Любимый язык программирования: $favoriteLang
        """.trimIndent()

        textView.text = info
    }

    private fun task2() {
        val pi = PI
        val radius = 5.0
        val side = 4.0

        val circleArea = pi * radius.pow(2)
        val squareArea = side * side

        val result = """
            Радиус круга = $radius
            Площадь круга = $circleArea
            
            Сторона квадрата = $side
            Площадь квадрата = $squareArea
        """.trimIndent()

        textView.text = result
    }

    private fun task3() {
        fun task3() {
            val inputSeconds = 3665

            val hours = inputSeconds / 3600
            val minutes = (inputSeconds % 3600) / 60
            val seconds = inputSeconds % 60

            val result = String.format("%02d:%02d:%02d", hours, minutes, seconds)

            textView.text = "Введено секунд: $inputSeconds\nРезультат: $result"
        }

    }

    private fun task4() {
        fun task4() {
            val USD_TO_EUR = 0.85
            val USD_TO_GBP = 0.74
            val USD_TO_JPY = 110.16

            val usdAmount = 100.0

            val eurAmount = usdAmount * USD_TO_EUR
            val gbpAmount = usdAmount * USD_TO_GBP
            val jpyAmount = usdAmount * USD_TO_JPY

            val result = """
        Сумма в USD: $usdAmount
        В EUR: %.2f
        В GBP: %.2f
        В JPY: %.2f
    """.trimIndent().format(eurAmount, gbpAmount, jpyAmount)
            textView.text = result
        }

    }
}
package com.example.homework_2

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.round
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        val spinner: Spinner = findViewById(R.id.taskSelector)

        val tasks = listOf("Task 1 — convertTemperature", "Task 2 — formatContactInfo", "Task 3 — generateGreeting")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tasks)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> task1()
                    1 -> task2()
                    2 -> task3()
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    // Task 1
    // Конвертации температуры
    private fun convertTemperature(temp: Double, toFahrenheit: Boolean): Double {
        return if (toFahrenheit) {
            // C -> F
            temp * 9.0 / 5.0 + 32.0
        } else {
            // F -> C
            (temp - 32.0) * 5.0 / 9.0
        }
    }

    private fun task1() {
        val celsius = 25.0
        val fFromC = convertTemperature(celsius, toFahrenheit = true)

        val fahrenheit = 77.0
        val cFromF = convertTemperature(fahrenheit, toFahrenheit = false)

        val result = """
            Пример 1: $celsius °C -> ${"%.2f".format(fFromC)} °F
            Пример 2: $fahrenheit °F -> ${"%.2f".format(cFromF)} °C
        """.trimIndent()

        textView.text = result
    }

    // Task 2
    // Форматирование контактной информации
    private fun formatContactInfo(name: String, email: String, phone: String): String {
        return """
            Контактная информация:
            Имя: $name
            Email: $email
            Телефон: $phone
        """.trimIndent()
    }

    private fun task2() {
        val name = "Иван Иванов"
        val email = "ivan@example.com"
        val phone = "+7 912 345-67-89"

        val formatted = formatContactInfo(name, email, phone)
        textView.text = formatted
    }

    // Task 3
    // Приветствие
    private fun generateGreeting(
        name: String,
        timeOfDay: String = "день",
        isSpecialOccasion: Boolean = false,
        vararg additionalMessages: String
    ): String {
        val base = if (isSpecialOccasion) {
            // более формальное приветствие
            "Уважаемый(ая) $name,\n"
        } else {
            // более простое/дружелюбное
            "Привет, $name!\n"
        }

        val timePart = when (timeOfDay.lowercase()) {
            "утро" -> "Хорошего утра!"
            "день" -> "Хорошего дня!"
            "вечер" -> "Хорошего вечера!"
            "ночь" -> "Спокойной ночи!"
            else -> "Хорошего дня!"
        }

        val extras = if (additionalMessages.isNotEmpty()) {
            "\nДоп. сообщения:\n" + additionalMessages.joinToString(separator = "\n") { "- $it" }
        } else {
            ""
        }

        return buildString {
            append(base)
            append(timePart)
            append(extras)
        }
    }

    private fun task3() {
        val g1 = generateGreeting("Ольга") // дефолт: день, не special
        val g2 = generateGreeting("Пётр", timeOfDay = "утро", isSpecialOccasion = true)
        val g3 = generateGreeting("Мария", timeOfDay = "вечер", false, "Рад вас видеть", "Завтра встреча в 18:00")

        val result = """
            Пример 1:
            $g1

            Пример 2:
            $g2

            Пример 3:
            $g3
        """.trimIndent()

        textView.text = result
    }
}

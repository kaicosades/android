package com.example.homework_3


import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        val spinner: Spinner = findViewById(R.id.taskSelector)

        val tasks = listOf(
            "Задача 1 — переменные",
            "Задача 2 — null и длина строки",
            "Задача 3 — сумма чётных чисел",
            "Задача 4 — фильтр слов",
            "Задача 5 — список имён"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tasks)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> task1()
                    1 -> task2()
                    2 -> task3()
                    3 -> task4()
                    4 -> task5()
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
    private fun task1() {
        val name: String = "Алексей"
        val age: Int = 24
        val hasDriverLicense: Boolean = true
        textView.text = "Имя: $name\nВозраст: $age\nПрава: $hasDriverLicense"
    }

    private fun task2() {
        val str: String? = null
        val result = str?.length ?: "Строка пуста"
        textView.text = result.toString()
    }

    private fun task3() {
        val numbers = (1..10).toList()
        var sum = 0
        for (n in numbers) {
            if (n % 2 == 0) sum += n
        }
        textView.text = "Сумма чётных чисел = $sum"
    }

    private fun task4() {
        val fruits = listOf("яблоко", "банан", "апельсин", "груша", "ананас")
        val filtered = fruits.filter { it.length > 5 }
        textView.text = "Слова > 5 символов: ${filtered.joinToString(", ")}"
    }

    private fun task5() {
        val names: List<String?> = listOf("Анна", null, "Борис", "Катя", null, "Денис")
        val filtered = names.filterNotNull()
        val sb = StringBuilder()
        for (name in filtered) {
            when {
                name.startsWith("А") -> sb.append("Имя начинается на А: $name\n")
                name.startsWith("Б") -> sb.append("Имя начинается на Б: $name\n")
                else -> sb.append("Другое имя: $name\n")
            }
        }
        textView.text = sb.toString()
    }
}
package com.example.homework_3

import android.os.Bundle
import android.view.View
import android.widget.*
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

        val tasks = listOf(
            "Задача 1 — пользователь с email",
            "Задача 2 — оценки в текст",
            "Задача 3 — животные",
            "Задача 4 — фигуры",
            "Задача 5 — пользователи > 18"
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

    //ЗАДАНИЕ 1
    private fun task1() {
        val name: String = "Алекс"
        var age: Int = 25
        val email: String? = null

        val result = email?.let { "Имя: $name, Возраст: $age, Email: $it" }
            ?: "Имя: $name, Возраст: $age, Email: не указан"

        textView.text = result
    }

    //ЗАДАНИЕ 2
    private fun task2() {
        val grades = listOf(5, 4, 3, 2, 1)
        val descriptions = grades.map { grade ->
            when (grade) {
                5 -> "Отлично"
                4 -> "Хорошо"
                3 -> "Удовлетворительно"
                2 -> "Неудовлетворительно"
                1 -> "Плохо"
                else -> "Неизвестная оценка"
            }
        }
        textView.text = descriptions.joinToString(", ")
    }

    //ЗАДАНИЕ 3
    open class Animal {
        open fun makeSound(): String = "Животное издает звук"
    }

    class Lion : Animal() {
        override fun makeSound(): String = "ррр"
    }

    class Monkey : Animal() {
        override fun makeSound(): String = "ууу ааа"
    }

    private fun task3() {
        val animals: List<Animal> = listOf(Lion(), Monkey())
        val sounds = buildString {
            for (a in animals) {
                appendLine(a.makeSound())
            }
        }
        textView.text = sounds
    }

    //ЗАДАНИЕ 4
    interface Drawable {
        fun draw(): String
    }

    sealed class Shape {
        abstract fun area(): Double
    }

    class Circle(private val radius: Double) : Shape(), Drawable {
        override fun area(): Double = PI * radius.pow(2)
        override fun draw(): String = "Круг с радиусом $radius"
    }

    class Rectangle(private val w: Double, private val h: Double) : Shape(), Drawable {
        override fun area(): Double = w * h
        override fun draw(): String = "Прямоугольник $w x $h"
    }

    class Triangle(private val a: Double, private val h: Double) : Shape(), Drawable {
        override fun area(): Double = 0.5 * a * h
        override fun draw(): String = "Треугольник (основание $a, высота $h)"
    }

    private fun task4() {
        val shapes: List<Shape> = listOf(
            Circle(3.0),
            Rectangle(4.0, 5.0),
            Triangle(6.0, 2.0)
        )
        val output = buildString {
            for (s in shapes) {
                val drawable = s as Drawable
                appendLine("${drawable.draw()}, площадь = ${s.area()}")
            }
        }
        textView.text = output
    }

    //ЗАДАНИЕ 5
    data class User(val name: String, val age: Int)

    private fun task5() {
        val users = listOf(
            User("Анна", 17),
            User("Борис", 20),
            User("Катя", 22),
            User("Денис", 19)
        )

        val adults = users
            .filter { it.age > 18 }
            .sortedBy { it.name }
            .map { it.name.uppercase() }

        textView.text = adults.joinToString(", ")
    }
}

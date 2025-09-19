package com.example.trafficlights

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.view.View


class TrafficLightActivity : AppCompatActivity() {

    private lateinit var red: View
    private lateinit var yellow: View
    private lateinit var green: View
    private var state = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        red = findViewById(R.id.redLight)
        yellow = findViewById(R.id.yellowLight)
        green = findViewById(R.id.greenLight)

        findViewById<Button>(R.id.btnChange).setOnClickListener {
            state = (state + 1) % 3
            updateLights()
        }

        updateLights()
    }

    private fun updateLights() {
        red.setBackgroundResource(if (state == 0) R.drawable.red_circle else R.drawable.gray_circle)
        yellow.setBackgroundResource(if (state == 1) R.drawable.yellow_circle else R.drawable.gray_circle)
        green.setBackgroundResource(if (state == 2) R.drawable.green_circle else R.drawable.gray_circle)
    }
}

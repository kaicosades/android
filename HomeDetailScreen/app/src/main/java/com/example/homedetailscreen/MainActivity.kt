package com.example.homedetailscreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGo = findViewById<Button>(R.id.btnGoToDetails)
        btnGo.setOnClickListener {
            val intent = Intent(this, DetailScreenActivity::class.java)
            intent.putExtra("userName", "userName")
            startActivity(intent)
        }
    }
}

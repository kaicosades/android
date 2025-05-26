package com.example.musicservice;

import android.os.Bundle;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Intent musicIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        musicIntent = new Intent(this, MusicService.class);

        Button startButton = findViewById(R.id.btnStart);
        Button stopButton = findViewById(R.id.btnStop);

        startButton.setOnClickListener(v -> startService(musicIntent));
        stopButton.setOnClickListener(v -> stopService(musicIntent));
    }
}
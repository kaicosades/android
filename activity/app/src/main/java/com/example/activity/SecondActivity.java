package com.example.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView nameOutput, ageOutput, accessMessage;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameOutput = findViewById(R.id.nameOutput);
        ageOutput = findViewById(R.id.ageOutput);
        accessMessage = findViewById(R.id.accessMessage);
        backButton = findViewById(R.id.backButton);

        String name = getIntent().getStringExtra("NAME");
        int age = getIntent().getIntExtra("AGE", 0);

        nameOutput.setText("Имя: " + name);
        ageOutput.setText("Возраст: " + age);

        if (age > 18) {
            accessMessage.setText("Доступ разрешен");
        }

        backButton.setOnClickListener(v -> finish());//finish закрывает текущую владку
    }
}

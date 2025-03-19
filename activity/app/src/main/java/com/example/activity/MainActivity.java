package com.example.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private EditText nameInput, ageInput;
    private Button nextButton;

    @Override // заменяет метод из родительского класса
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //super - вызов метода род класса
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        ageInput = findViewById(R.id.ageInput);
        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString();// получение текста соответсвенно из поля
            String ageStr = ageInput.getText().toString();
            int age = ageStr.isEmpty() ? 0 : Integer.parseInt(ageStr);//проверка на пустую строку

            if (!name.isEmpty()) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("NAME", name);//перенос в second
                intent.putExtra("AGE", age);
                startActivity(intent);//intent создается для перехода между экранами
            }
        });
    }



}

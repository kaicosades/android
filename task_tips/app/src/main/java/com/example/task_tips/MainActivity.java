package com.example.task_tips;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText orderAmountInput;
    private Spinner tipPercentageSpinner;
    private TextView totalAmountValue;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Найдем элементы
        orderAmountInput = findViewById(R.id.orderAmountInput);
        tipPercentageSpinner = findViewById(R.id.tipPercentageSpinner);
        totalAmountValue = findViewById(R.id.totalAmountValue);
        submitButton = findViewById(R.id.submitButton);

        // Обработчик для кнопки
        submitButton.setOnClickListener(v -> calculateTotal());

        // Обработчик для изменения значения в Spinner
        tipPercentageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculateTotal(); // Автоматически пересчитываем сумму
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Код для изменения отступов
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Метод расчета итоговой суммы
    private void calculateTotal() {
        String orderAmountStr = orderAmountInput.getText().toString();

        if (orderAmountStr.isEmpty()) {
            totalAmountValue.setText("0.00 ₽");
            return;
        }

        double orderAmount = Double.parseDouble(orderAmountStr);

        // Получаем процент чаевых
        String selectedTip = tipPercentageSpinner.getSelectedItem().toString();
        int tipPercent = Integer.parseInt(selectedTip.replace("%", "")); // Убираем % и конвертируем в число

        // Рассчитываем итоговую сумму
        double total = orderAmount + (orderAmount * tipPercent / 100.0);

        // Устанавливаем результат
        totalAmountValue.setText(String.format("%.2f ₽", total));
    }
}


package com.example.bookroom;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.example.bookroom.data.AppDatabase;
import com.example.bookroom.data.Book;
import java.util.List;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        listView = findViewById(R.id.listView);
        Button button = findViewById(R.id.button);

        db = AppDatabase.getInstance(this);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        loadBooks();

        button.setOnClickListener(v -> {
            String title = editText.getText().toString().trim();
            if (!title.isEmpty()) {
                Executors.newSingleThreadExecutor().execute(() -> {
                    db.bookDao().insert(new Book(title));
                    runOnUiThread(this::loadBooks);
                });
                editText.setText("");
            }
        });
    }

    private void loadBooks() {
        Executors.newSingleThreadExecutor().execute(() -> {
            List<Book> books = db.bookDao().getAllBooks();
            runOnUiThread(() -> {
                adapter.clear();
                for (Book book : books) {
                    adapter.add(book.title);
                }
            });
        });
    }
}
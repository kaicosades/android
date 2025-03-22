package com.example.webview;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;




import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {

    //Для доступа в интернет был добавлен <uses-permission android:name="android.permission.INTERNET"/> в AndroidManifest.xml
    private WebView webView;
    private EditText urlInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        urlInput = findViewById(R.id.urlInput);
        Button loadPageButton = findViewById(R.id.loadPageButton);

        // Настройка WebView
        WebSettings webSettings = webView.getSettings(); // получаем существующий объект из библиотеки
        webSettings.setJavaScriptEnabled(true); //Нужно, чтобы браузер поддерживал java
        webView.setWebViewClient(new WebViewClient()); //открытие ссылки не в браузере

        loadPageButton.setOnClickListener(v -> {
            String url = urlInput.getText().toString().trim();

            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }

            webView.loadUrl(url);
        });
    }
}
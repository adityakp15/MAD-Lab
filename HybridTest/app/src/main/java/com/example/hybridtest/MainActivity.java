package com.example.hybridtest;

import static android.Manifest.permission.INTERNET;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText url;
    WebView w;
    Button staticp,dynamic;
    String staticn = "hi.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this,new String[]{INTERNET},1);

        staticp = findViewById(R.id.button);
        dynamic = findViewById(R.id.button2);
        w = findViewById(R.id.webView);
        w.getSettings().setJavaScriptEnabled(true);
        url = findViewById(R.id.url);

        staticp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w.loadUrl("file:///android_asset/"+staticn);
            }
        });

        dynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w.loadUrl("https://www."+url.getText().toString());
            }
        });
    }
}
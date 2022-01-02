package com.example.graphicstest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button draw = findViewById(R.id.button1);
        draw.setOnClickListener(view -> {
            Intent mainPage = new Intent(getApplicationContext(), DrawShapes.class);
            MainActivity.this.startActivity(mainPage);
        });

        Button image = findViewById(R.id.button2);
        image.setOnClickListener(view -> {
            Intent mainPage = new Intent(MainActivity.this, ImageAnimations.class);
            startActivity(mainPage);
        });

        Button car = findViewById(R.id.button3);
        car.setOnClickListener(view -> {
            Intent mainPage = new Intent(MainActivity.this, CarAnimations.class);
            startActivity(mainPage);
        });
    }
}

package com.example.graphicstest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DrawShapes extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_shapes);

        Bitmap bitmap = Bitmap.createBitmap(392, 607, Bitmap.Config.ARGB_8888);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setBackgroundDrawable(new BitmapDrawable(bitmap));
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(20);

        // drawing a line
        canvas.drawText("Line", 150, 50, paint);
        canvas.drawLine(20, 70, 400, 70, paint);

        // drawing a circle
        canvas.drawText("Circle", 150, 130, paint);
        canvas.drawCircle(180, 200, 60, paint);

        // drawing a rectangle
        canvas.drawText("Rectangle", 150, 320, paint);
        canvas.drawRect(100, 335, 300, 415, paint);

        // drawing an arc
        canvas.drawText("Arc", 150, 470, paint);
        canvas.drawArc(100, 440, 300, 560, 0, 160, true, paint);

        Button back = findViewById(R.id.button1);
        back.setOnClickListener(view -> {
            Intent mainPage = new Intent(DrawShapes.this, MainActivity.class);
            startActivity(mainPage);
        });
    }
}


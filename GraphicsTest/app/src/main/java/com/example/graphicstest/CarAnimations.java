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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class CarAnimations extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_animations);

        Bitmap bitmap = Bitmap.createBitmap(300, 400, Bitmap.Config.ARGB_8888);
        ImageView imageView = findViewById(R.id.imageView3);
        imageView.setBackgroundDrawable(new BitmapDrawable(bitmap));
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        canvas.drawLine(30,180,30,250,paint);
        canvas.drawLine(30,180,270,180,paint);
        canvas.drawLine(270,180,270,250,paint);
        canvas.drawLine(30,250,270,250,paint);

        canvas.drawLine(100,130,200,130,paint);
        canvas.drawLine(200,130,200,180,paint);
        canvas.drawLine(200,180,100,180,paint);
        canvas.drawLine(100,180,100,130,paint);

        canvas.drawCircle(80,250,20, paint);
        canvas.drawCircle(220,250,20, paint);

        Button back = findViewById(R.id.button8);
        back.setOnClickListener(view -> {
            Intent mainPage = new Intent(CarAnimations.this, MainActivity.class);
            startActivity(mainPage);
        });
    }

    public void zoom(View view) {
        ImageView image = (ImageView)findViewById(R.id.imageView3);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        image.startAnimation(animation1);
    }

    public void rotate(View view) {
        ImageView image = (ImageView)findViewById(R.id.imageView3);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        image.startAnimation(animation1);
    }

    public void fade(View view) {
        ImageView image = (ImageView)findViewById(R.id.imageView3);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        image.startAnimation(animation1);
    }

    public void blink(View view) {
        ImageView image = (ImageView)findViewById(R.id.imageView3);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        image.startAnimation(animation1);
    }

    public void slide(View view) {
        ImageView image = (ImageView)findViewById(R.id.imageView3);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        image.startAnimation(animation1);
    }

    public void move(View view) {
        ImageView image = (ImageView)findViewById(R.id.imageView3);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        image.startAnimation(animation1);
    }
}

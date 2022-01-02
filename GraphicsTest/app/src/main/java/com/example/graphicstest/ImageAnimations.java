package com.example.graphicstest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class ImageAnimations extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_animations);

        Button back = findViewById(R.id.button8);
        back.setOnClickListener(view -> {
            Intent mainPage = new Intent(ImageAnimations.this, MainActivity.class);
            startActivity(mainPage);
        });
    }

    public void zoom(View view) {
        ImageView image = (ImageView)findViewById(R.id.imageView2);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        image.startAnimation(animation1);
    }

    public void rotate(View view) {
        ImageView image = (ImageView)findViewById(R.id.imageView2);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        image.startAnimation(animation1);
    }

    public void fade(View view) {
        ImageView image = (ImageView)findViewById(R.id.imageView2);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        image.startAnimation(animation1);
    }

    public void blink(View view) {
        ImageView image = (ImageView)findViewById(R.id.imageView2);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        image.startAnimation(animation1);
    }

    public void slide(View view) {
        ImageView image = (ImageView)findViewById(R.id.imageView2);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        image.startAnimation(animation1);
    }

    public void move(View view) {
        ImageView image = (ImageView)findViewById(R.id.imageView2);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        image.startAnimation(animation1);
    }
}


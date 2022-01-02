package com.example.multithreadingtest;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public Button startButton, resetButton, colorButton;

    public TextView tv;
    public final Handler ha = new Handler();
    int idx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView2);

        startButton = findViewById(R.id.startButton);
        resetButton = findViewById(R.id.resetButton);
        colorButton = findViewById(R.id.leftButton);


        startButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                runnable.run();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ha.removeCallbacks(runnable);
            }
        });

        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            tv.setTextColor(getRandomColor());
                            tv.setBackgroundColor(getRandomColor());
                        }
                        catch (Exception e){
                            //toast error
                        }
                    }
                }).start();
            }
        });

    }

    public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    public String getSomeText(){
        String name[] = {"Hi","this","is","a","scrolling","text"};
        String t = name[idx];
        idx = (idx+1)%6;
        return t;
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                doTask();
            }catch (Exception e){
                e.printStackTrace();
            } finally {
                ha.postDelayed(runnable, 500);
            }
        }
    };

    public void doTask() {
        tv.setText(getSomeText());
    }
}

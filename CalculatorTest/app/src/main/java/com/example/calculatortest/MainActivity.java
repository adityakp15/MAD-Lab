package com.example.calculatortest;

import androidx.appcompat.app.AppCompatActivity;
import com.fathzer.soft.javaluator.DoubleEvaluator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText exp;
    Button solve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exp = findViewById(R.id.exp);
        solve = findViewById(R.id.button);

        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DoubleEvaluator evaluator = new DoubleEvaluator();
                String result = evaluator.evaluate(exp.getText().toString()).toString();
                exp.setText(result);
            }
        });
    }
}
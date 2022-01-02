package com.example.sdcardtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class MainActivity extends AppCompatActivity {

    EditText name,content;
    Button read,write;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this,new String[]{READ_EXTERNAL_STORAGE,WRITE_EXTERNAL_STORAGE},1);

        name = findViewById(R.id.fname);
        content = findViewById(R.id.content);
        read = findViewById(R.id.read);
        write = findViewById(R.id.write);
        String filepath = "Files";

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File(getExternalFilesDir(filepath),name.getText().toString());

                try{
//                    creating file output stream to write to file
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
//                    converting content to bytes to write into file.
                    fileOutputStream.write(content.getText().toString().getBytes());
                    fileOutputStream.close();
                    content.setText("");
                    Toast.makeText(getApplicationContext(),"File written",Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Write Failed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String line,text = "";
                File file = new File(getExternalFilesDir(filepath),name.getText().toString());

                try {
//                    BufferedReader to read text from character based input stream.
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    while((line = bufferedReader.readLine())!= null){
                        text += line;
                    }
                    content.setText(text);
                    Toast.makeText(getApplicationContext(), "File Read.", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Couldn't read from file", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
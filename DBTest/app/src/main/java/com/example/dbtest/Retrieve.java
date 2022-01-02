package com.example.dbtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Retrieve extends AppCompatActivity {
    TextView ret;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        Intent intent = getIntent();
        String dbId = intent.getStringExtra("key");
        Cursor cursor;
        ret = findViewById(R.id.ret);
        int i =0;
        String details = "";

        try{
            db = openOrCreateDatabase("DB",MODE_PRIVATE,null);
//            retrieve one
//            cursor = db.rawQuery("select * from test;",new String[]{dbId});
//            retrieve all
            cursor = db.rawQuery("select * from test;",new String[]{});
            while(cursor.moveToNext()){
//                for one record
//                ret.setText(cursor.getString(i));
                details += cursor.getString(0);
                details += cursor.getString(1);
                details += "\n";
                i++;
                ret.setText(details);
            }

        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Could not retrieve",Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getApplicationContext(),dbId,Toast.LENGTH_SHORT).show();
    }
}
package com.example.dbtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,id,opt;
    Button insert,delete,update,ret;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        id = findViewById(R.id.id);
        opt = findViewById(R.id.opt);

        insert = findViewById(R.id.insert);
        delete = findViewById(R.id.delete);
        update = findViewById(R.id.update);
        ret = findViewById(R.id.view);


        db = openOrCreateDatabase("DB",MODE_PRIVATE,null);
        db.execSQL("drop table if exists test;");
        db.execSQL("create table test(id number primary key,name varchar(20));");
        Toast.makeText(getApplicationContext(),"Created", Toast.LENGTH_SHORT).show();

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dbName = name.getText().toString();
                String dbId = id.getText().toString();
                try {
                    db.execSQL("insert into test values(?,?)", new String[]{dbId, dbName});
                    Toast.makeText(getApplicationContext(), "Inserted !", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Insertion Failed !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dbName = name.getText().toString();
                String dbId = id.getText().toString();

                try{
                    db.execSQL("update test set name = ? where id = ?;",new String[]{dbName,dbId});
                    Toast.makeText(getApplicationContext(),"Updated !",Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Update Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dbId = id.getText().toString();

                try{
                    db.execSQL("delete from test where id = ?;",new String[]{dbId});
                    Toast.makeText(getApplicationContext(),"Deleted !",Toast.LENGTH_SHORT).show();
                } catch(Exception e){
                    Toast.makeText(getApplicationContext(),"Deletion Failed",Toast.LENGTH_SHORT).show();
                }

            }
        });

        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dbId = id.getText().toString();
                Intent myIntent = new Intent(getApplicationContext(),Retrieve.class);
                myIntent.putExtra("key",dbId);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}
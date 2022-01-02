package com.example.smstest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.READ_SMS;
import static android.Manifest.permission.RECEIVE_SMS;
import static android.Manifest.permission.SEND_SMS;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText no,msg;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        no = findViewById(R.id.no);
        msg = findViewById(R.id.msg);
        send = findViewById(R.id.button);
//        Requesting permission
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{READ_SMS, SEND_SMS, RECEIVE_SMS, READ_PHONE_STATE},1);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = no.getText().toString();
                String message = msg.getText().toString();

                PendingIntent sentPI = PendingIntent.getBroadcast(getApplicationContext(),0,new Intent("Message Sent"),0);
                PendingIntent deliveredPI = PendingIntent.getBroadcast(getApplicationContext(),0,new Intent("Message delivered"),0);

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(number,null,message,sentPI,deliveredPI);

                Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
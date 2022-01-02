package com.example.gpstest;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LocationListener{

    TextView tvLatitude, tvLongitude;
    Button get;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        get = findViewById(R.id.buttonGet);

        ActivityCompat.requestPermissions(MainActivity.this,new String[]{ACCESS_COARSE_LOCATION,ACCESS_FINE_LOCATION},1);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                getLocation();
            }
        });
    }

    void getLocation(){
        try{
            locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates("gps",1000,5,(LocationListener) this);
        }
        catch(SecurityException e){
            //error toast
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        tvLatitude = findViewById(R.id.latitude);
        tvLongitude = findViewById(R.id.longitude);
        String latitude = "Latitude: "+location.getLatitude();
        String longitude = "Longitude: "+location.getLongitude();
        tvLatitude.setText(latitude);
        tvLongitude.setText(longitude);
    }
}
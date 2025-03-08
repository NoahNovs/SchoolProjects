package com.example.project10_nnovales;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    GestureDetector gestureDetector;
    SensorManager mySensorManager;
    LocationManager lm;
    Sensor temp, pressure;
    double longi,lat;
    TextView tempText,pressureText,locationText,cityText,stateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tempText = findViewById(R.id.tempView);
        locationText = findViewById(R.id.locationView);
        cityText = findViewById(R.id.cityView);
        stateText = findViewById(R.id.stateView);
        pressureText = findViewById(R.id.pressureView);


        mySensorManager = (SensorManager)this.getSystemService(SENSOR_SERVICE);
        temp = mySensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        pressure = mySensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);


        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        displayLocation();

        gestureDetector = new GestureDetector(this,new GestureListener());


    }

    @Override
    protected void onResume() {
        super.onResume();
        mySensorManager.registerListener(this,temp,SensorManager.SENSOR_DELAY_NORMAL);
        mySensorManager.registerListener(this,pressure,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySensorManager.unregisterListener(this,temp);
        mySensorManager.unregisterListener(this,pressure);
    }

    @SuppressLint("SetTextI18n")
    private void displayLocation()
    {
        if (!lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            OnGPS();
        } else {
            getLocation();
        }

        Geocoder geocoder = new Geocoder(this);
        try {
            List<Address> someList = geocoder.getFromLocation(lat,longi,1);
            locationText.setText("Location: " + someList.get(0).getAddressLine(0));
            cityText.setText("City: " + someList.get(0).getLocality());
            stateText.setText("State: " + someList.get(0).getAdminArea());
        } catch (IOException e) {
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
        }
    }


    private void OnGPS() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Enable GPS").setCancelable(false).setPositiveButton("Yes", new  DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(
                MainActivity.this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            Location locationGPS = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (locationGPS != null) {
                lat = locationGPS.getLatitude();
                longi = locationGPS.getLongitude();
            } else {
                Toast.makeText(this, "Unable to find location.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE)
        {
            float fahrenheit = event.values[0] * 9 / 5 + 32;
            tempText.setText("Temperature (Fahrenheit): " + String.valueOf(fahrenheit));
            //tempText.invalidate();
        }
        else if(event.sensor.getType() == Sensor.TYPE_PRESSURE)
        {
            pressureText.setText("Air Pressure (hPa): " + event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener
    {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            startActivity(new Intent(MainActivity.this,GestureActivity.class));
            //Toast.makeText(MainActivity.this, "Fling", Toast.LENGTH_SHORT).show();
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
package com.example.selfieaday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    StorageReference storageRef;
    FirebaseStorage storage;
    ProgressDialog progressDialog;
    RecyclerView rView;
    ArrayList<PictureImage> imageList = new ArrayList<>();;
    SensorManager sensorManager;
    SensorEventListener sensorEventListener;
    Sensor sensorShake;
    ImageAdapter imageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //create sensor
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorShake = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if(event != null)
                {
                    float x_accl = event.values[0];
                    float y_accl = event.values[1];
                    float z_accl = event.values[2];

                    float sum = Math.abs(x_accl)+Math.abs(y_accl)+Math.abs(z_accl);

                    if(sum > 15)
                    {
                        startActivity(new Intent(MainActivity.this,CameraActivity.class));
                    }
                }
                //Toast.makeText(MainActivity.this,"This was called",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };


        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
        rView = findViewById(R.id.recycleView);
//        progressDialog = new ProgressDialog(MainActivity.this);
//        progressDialog.setCancelable(false);
//        progressDialog.show();

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager
                (2, LinearLayoutManager.VERTICAL);
        rView.setLayoutManager(staggeredGridLayoutManager);


        storageRef.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                for (int i = 1; i < listResult.getItems().size(); i++) {

                    imageList.add(new PictureImage(String.valueOf(i),storageRef.child("images/"+ i +".jpg").getDownloadUrl().toString()));
                }
                imageAdapter = new ImageAdapter(MainActivity.this, imageList);
                rView.setAdapter(imageAdapter);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(sensorEventListener,sensorShake,SensorManager.SENSOR_DELAY_GAME);
        storageRef.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                for (int i = 0; i < listResult.getItems().size(); i++) {
                    imageList.add(new PictureImage(String.valueOf(i),listResult.getItems().get(i).getDownloadUrl().toString()));
                }
            }
        });

        //Log.d("WHAT", String.valueOf(imageList));
        imageAdapter = new ImageAdapter(this, imageList);
        rView.setAdapter(imageAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
    }
}
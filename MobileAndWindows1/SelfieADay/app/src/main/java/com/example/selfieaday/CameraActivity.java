package com.example.selfieaday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
public class CameraActivity extends AppCompatActivity implements View.OnClickListener {

    boolean defCamera;
    PreviewView previewView;
    Preview preview;
    Button capture, switchCamera;
    CameraSelector cameraSelector;
    ProcessCameraProvider cameraProvider;
    private final int REQUEST_CODE_PERMISSIONS = 100;
    private final String[] REQUIRED_PERMISSIONS = new String[]{"android.permission.CAMERA","android.permission.WRITE_EXTERNAL_STORAGE"};
    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
    private ImageCapture imageCapture;

    StorageReference storageRef;
    FirebaseStorage storage;
    StorageReference mountainsRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        defCamera = true;

        previewView = findViewById(R.id.previewView);
        capture = findViewById(R.id.camButton);
        switchCamera = findViewById(R.id.switchCamera);

        capture.setOnClickListener(this);
        switchCamera.setOnClickListener(this);

        storage = FirebaseStorage.getInstance();


        storageRef = storage.getReference();

        mountainsRef = storageRef.child("images/");




        if (allPermissionsGranted()) {
            startCameraX();
        } else {
            ActivityCompat.requestPermissions(this,
                    REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS);
        }

    }// end of onCreate


    private void startCameraX() {
        cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        cameraProviderFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    cameraProvider = cameraProviderFuture.get();
                    bindPreview(cameraProvider);

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, ContextCompat.getMainExecutor(this));


    }

    void bindPreview(@NonNull ProcessCameraProvider cameraProvider) {

        cameraProvider.unbindAll();


        //Selector Use case
        if (defCamera) {
            cameraSelector = new CameraSelector.Builder()
                    .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                    .build();

        } else {
            cameraSelector = new CameraSelector.Builder()
                    .requireLensFacing(CameraSelector.LENS_FACING_FRONT)
                    .build();
        }


        //Preview Use case
        preview = new Preview.Builder().build();
        preview.setSurfaceProvider(previewView.getSurfaceProvider());

        //ImageCapture use case
        imageCapture = new ImageCapture.Builder()
                .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
                .setTargetRotation(this.getWindowManager().getDefaultDisplay().getRotation())
                .build();





        cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageCapture);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.camButton:
                capturePhoto();
                break;


            case R.id.switchCamera:
                defCamera = !defCamera;
                startCameraX();
                break;
        }

    }

    private void capturePhoto() {
        final int[] count = new int[1];
        mountainsRef.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                for(StorageReference item: listResult.getItems())
                {
                    count[0] = listResult.getItems().size();
                }
            }
        });

        count[0] = count[0] + 1;
        SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
        File file = new File(getExternalFilesDir("asd"), new Date()+ ".jpg");

        ImageCapture.OutputFileOptions outputFileOptions = new ImageCapture.OutputFileOptions.Builder(file).build();


        Log.d("THIS", "capturePhoto: was called");
        imageCapture.takePicture(outputFileOptions,
                ContextCompat.getMainExecutor(this),
                new ImageCapture.OnImageSavedCallback() {
                    @SuppressLint("SuspiciousIndentation")
                    @Override
                    public void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults) {

                        Uri picUri = outputFileResults.getSavedUri();
                        if (picUri == null){
                            Toast.makeText(CameraActivity.this, "Uri is Empty, Image might be saved", Toast.LENGTH_SHORT).show();
                        }else
                            mountainsRef.child(String.valueOf(count[0]+1)).putFile(picUri);

                        Toast.makeText(CameraActivity.this, "Image saved at " + picUri.getPath() + " Uri is not Empty, saved", Toast.LENGTH_SHORT).show();
                    }


                    @Override
                    public void onError(@NonNull ImageCaptureException exception) {
                        exception.printStackTrace();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(CameraActivity.this, "Image Capture error", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });

        startActivity(new Intent(CameraActivity.this,MainActivity.class));
    }

    public String getBatchDirectoryName() {

        String app_folder_path = "";
        app_folder_path = Environment.getExternalStorageDirectory().toString() + "/CameraX";
        File dir = new File(app_folder_path);
        if (!dir.exists() && !dir.mkdirs()) {

        }

        return app_folder_path;
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //start camera when permissions have been granted otherwise exit app
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                startCameraX();
            } else {
                Toast.makeText(this, "Permissions not granted by the user.", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    private boolean allPermissionsGranted(){
        //check if req permissions have been granted
        for(String permission : REQUIRED_PERMISSIONS){
            if(ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }


}
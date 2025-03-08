package com.example.selfieaday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FullSizeImage extends AppCompatActivity {

    ImageView imageView2;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_size_image);

        Intent intent = getIntent();

        imageView2 = findViewById(R.id.imageView1);
        back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    v.getContext().startActivity(new Intent(FullSizeImage.this,
                            MainActivity.class));
            }
        });

        Glide.with(this).load(intent.getStringExtra("URL")).into(imageView2);


    }
}
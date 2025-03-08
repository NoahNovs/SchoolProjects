package com.example.notesapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b,usr;
    RecyclerView recyclerView;
    ArrayList<newNote> data = new ArrayList<>();
    CustomAdapter customAdapter;
    private DatabaseReference db;
    FirebaseUser users;

    @SuppressLint("UseSupportActionBar")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Toolbar toolbar = findViewById(R.id.toolbar1);
            setSupportActionBar(toolbar);

            b = findViewById(R.id.noteBtn);
            usr = findViewById(R.id.userBtn);
            recyclerView = findViewById(R.id.rView);
            b.setOnClickListener(this);
            usr.setOnClickListener(this);
            db = FirebaseDatabase.getInstance().getReference("Registered Users");
            //startActivity(new Intent(MainActivity.this,UserActivity.class));
            users = FirebaseAuth.getInstance().getCurrentUser();
            if(users == null)
            {
                startActivity(new Intent(MainActivity.this,UserActivity.class));
            }


        // staggeredGridLayoutManager with 2 columns and vertical orientation

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager
                (2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);


        db.child(users.getUid()).addValueEventListener(listen);
        customAdapter = new CustomAdapter(data);
        recyclerView.setAdapter(customAdapter);

    }

    @Override
    public void onClick(View view) {
        if(view.equals(b))
            mStartForResult.launch(new Intent(MainActivity.this,NoteActivity.class));
        else if(view.equals(usr))
        {
            startActivity(new Intent(MainActivity.this,UserActivity.class));
        }

    }
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult
            (new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            try {
                Intent intent = result.getData();
                assert intent != null;

                newNote someNote = new newNote();
                someNote.setNoteTitle(intent.getStringExtra("NOTETITLE"));
                someNote.setNoteContent(intent.getStringExtra("NOTEDESC"));
                db.child(users.getUid()).child(someNote.getNoteTitle()).setValue(someNote);
            }
            catch (Exception e)
            {
                Log.d("WRONG","Something went wrong",e);
            }

        }
    });

    ValueEventListener listen = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            try {
                data.clear();
                for (DataSnapshot s : snapshot.getChildren()) {
                    newNote someNote = s.getValue(newNote.class);
                    data.add(someNote);
                }

                customAdapter.notifyDataSetChanged();
            }catch(Exception e)
            {
                Log.d("ARRAYLIST", e.getMessage());
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

}

package com.example.finalapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    Toolbar toolbar;
    Button add;
    FloatingActionButton addBtn;
    ArrayList<Reminder> data = new ArrayList<>();
    private DatabaseReference db;
    CustomAdapter customAdapter;

    @SuppressLint("UseSupportActionBar")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseDatabase.getInstance().getReference("Reminders");
        db.addValueEventListener(listen);
        addBtn = findViewById(R.id.fab);
        addBtn.setOnClickListener(this);
        recyclerView = findViewById(R.id.rView);
        // staggeredGridLayoutManager with 2 columns and vertical orientation

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager
                (2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        customAdapter = new CustomAdapter(data, this);
        recyclerView.setAdapter(customAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            //open email
            case R.id.feedbackItem:
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"nnovales@iu.edu"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                startActivity(intent);
                break;
                //open website intent
            case R.id.aboutItem:
                Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://luddy.indiana.edu/"));
                startActivity(implicit);
                break;
                //open new activity
            case R.id.newItem:
                startActivity(new Intent(MainActivity.this,ReminderActivity.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    ValueEventListener listen = new ValueEventListener() {
        @SuppressLint("NotifyDataSetChanged")
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            try {
                data.clear();

                for (DataSnapshot s : snapshot.getChildren()) {
                    Reminder someNote = s.getValue(Reminder.class);
                    data.add(someNote);
                }
                Log.d("TAG", data.toString());
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

    @Override
    public void onClick(View v) {
        if(v.equals(addBtn))
        {
            startActivity(new Intent(MainActivity.this,ReminderActivity.class));
        }
    }


}
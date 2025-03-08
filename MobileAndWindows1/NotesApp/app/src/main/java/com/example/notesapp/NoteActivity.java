package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class NoteActivity extends AppCompatActivity implements View.OnClickListener{

    EditText title;
    EditText desc;
    Button s, del;
    Intent intent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        Toolbar toolbar = findViewById(R.id.toolbarNote);
        setSupportActionBar(toolbar);

        //attach editTexts and button
        title = findViewById(R.id.editTextTextTitle);
        desc = findViewById(R.id.editTextTextDescription);
        del = findViewById(R.id.delBtn);
        del.setOnClickListener(this);

        intent1 = getIntent();
        assert intent1 != null;
        title.setText(intent1.getStringExtra("TITLE"));
        desc.setText(intent1.getStringExtra("CONT"));
        s = findViewById(R.id.button2);
        s.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.equals(s))
        {
            //send back the data to the MainActivity where
            //it can be displayed in RecyclerView and stored in database
            Intent intent = new Intent();
            intent.putExtra("NOTETITLE", title.getText().toString());
            intent.putExtra("NOTEDESC", desc.getText().toString());
            intent.putExtra("POS1",intent1.getIntExtra("POS",1));
            Log.d("HELLO", "onClick: ");
            setResult(RESULT_OK,intent);
            finish();
        }
        else if(v.equals(del))
        {
            DeleteDialogFragment delete = new DeleteDialogFragment();
            //delete.startActivity(new Intent());
            delete.show(getSupportFragmentManager(),"MyFragment");
        }
    }
}
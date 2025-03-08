package com.example.finalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Locale;

public class ReminderActivity extends AppCompatActivity implements View.OnClickListener{

    EditText title,desc;
    Button date,time;
    Intent intent1;
    int hour, min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        title = findViewById(R.id.editTextTextTitle);
        desc = findViewById(R.id.editTextTextDescription);
        date = findViewById(R.id.pickDate);
        time = findViewById(R.id.pickTime);
        intent1 = getIntent();
        if(intent1.getStringExtra("TITLE") != null)
        {
            title.setText(intent1.getStringExtra("TITLE"));
            desc.setText(intent1.getStringExtra("DESC"));
            date.setText(intent1.getStringExtra("DATE"));
            time.setText(intent1.getStringExtra("TIME"));
        }

        date.setOnClickListener(this);
        time.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_reminder,menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.del)
        {
            Intent someIntent = getIntent();
            deleteDialogFragment delete = new deleteDialogFragment();
            Bundle args = new Bundle();
            args.putString("TITLE",someIntent.getStringExtra("TITLE"));
            delete.setArguments(args);
            delete.show(getSupportFragmentManager(),"Delete");
        }
        return super.onOptionsItemSelected(item);
    }



    //when the back button is pressed, then it calls this function
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        DatabaseReference db;
        db = FirebaseDatabase.getInstance().getReference("Reminders");
        Reminder x = new Reminder();
        x.setTitle(title.getText().toString());
        x.setDesc(desc.getText().toString());
        x.setDate(date.getText().toString());
        x.setTime(time.getText().toString());
        db.child(x.getTitle()).setValue(x);
    }



    @Override
    public void onClick(View v) {
        //if clicked, ask them for a date/time for each respective button
        if(v.equals(date))
        {
            DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    month++;
                    String dateString = makeDateString(month,dayOfMonth,year);
                    date.setText(dateString);
                }
            };

            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            int style = AlertDialog.THEME_HOLO_DARK;
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,style,onDateSetListener,year,month,day);
            datePickerDialog.show();
        }
        else if(v.equals(time))
        {
            TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    hour = hourOfDay;
                    min = minute;
                    time.setText(String.format(Locale.getDefault(),"%02d:%02d",hour,min));
                }
            };

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, AlertDialog.THEME_HOLO_DARK, onTimeSetListener,hour,min,true);
            timePickerDialog.setTitle("Select Time");
            timePickerDialog.show();
        }
    }

    private String makeDateString(int month, int dayOfMonth, int year) {
        return month + "/" + dayOfMonth + "/" + year;
    }
}
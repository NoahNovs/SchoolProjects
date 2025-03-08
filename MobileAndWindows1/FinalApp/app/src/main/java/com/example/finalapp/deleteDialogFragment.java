package com.example.finalapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class deleteDialogFragment extends DialogFragment{

    String title;

    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setMessage("Are you sure you want to delete?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("TAG", "Yes was clicked");
                        DatabaseReference db = FirebaseDatabase.getInstance().getReference("Reminders");
                        db.child(title).removeValue();
                        startActivity(new Intent(getContext(),MainActivity.class));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("TAG", "No was clicked");
                        dismiss();
                    }
                }).create();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle mArgs = getArguments();
        assert mArgs != null;
        title = mArgs.getString("TITLE");
        super.onCreate(savedInstanceState);
    }
}

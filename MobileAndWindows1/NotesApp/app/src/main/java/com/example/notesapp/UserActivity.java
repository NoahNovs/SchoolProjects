package com.example.notesapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText name,pass;
    Button signUp,logOut,signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        //assign variables
        name = findViewById(R.id.editTextTextPersonName);
        pass = findViewById(R.id.editTextTextPassword);
        signUp = findViewById(R.id.button3);
        signIn = findViewById(R.id.button4);
        logOut = findViewById(R.id.button7);

        //get the authentication instance from firebase
        mAuth = FirebaseAuth.getInstance();

        //if there is a user signed in, have them only sign out
        if(mAuth.getCurrentUser() != null)
        {
            Toast.makeText(UserActivity.this, "Already signed in. Log Out?", Toast.LENGTH_SHORT).show();
            signIn.setEnabled(false);
            signUp.setEnabled(false);
        }

        //event listener for sign out
        //sets the other buttons to true and alerts the user if signed out
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Toast.makeText(UserActivity.this, "Signed out.", Toast.LENGTH_SHORT).show();
                signUp.setEnabled(true);
                signIn.setEnabled(true);
            }
        });

        //signing in
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString().trim();
                String passwrd = pass.getText().toString().trim();

                if(TextUtils.isEmpty(n))
                {
                    name.setError("Username is required");
                    return;
                }

                if(TextUtils.isEmpty(passwrd))
                {
                    pass.setError("Password is required");
                    return;
                }

                //authenticate user if it is in database
                mAuth.signInWithEmailAndPassword(n,passwrd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(UserActivity.this, "User signed in", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else
                            Toast.makeText(UserActivity.this, "An error has occurred" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        //sign up for a username/password
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString().trim();
                String passwrd = pass.getText().toString().trim();

                if(TextUtils.isEmpty(n))
                {
                    name.setError("Username is required");
                    return;
                }

                if(TextUtils.isEmpty(passwrd))
                {
                    pass.setError("Password is required");
                    return;
                }

                mAuth.createUserWithEmailAndPassword(n,passwrd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(UserActivity.this, "User created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else
                            Toast.makeText(UserActivity.this, "An error has occurred" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
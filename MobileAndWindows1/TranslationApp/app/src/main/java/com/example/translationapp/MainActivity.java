package com.example.translationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.*;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    SharedViewModel sharedViewModel;
    TextView textView;
    RadioGroup firstSet, secondSet;
    RadioButton choice1, choice2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        textView = findViewById(R.id.mainTextView);


        getSupportFragmentManager().beginTransaction()
                .add(R.id.Fragment1, word.class, null).commit();

        firstSet = findViewById(R.id.setLang);
        secondSet = findViewById(R.id.transLang);

        Observer<String> obsver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                try{
                    //i did put all of this in other methods, but I did not have time
                    //after bug testing to put it back
                    int radioID = firstSet.getCheckedRadioButtonId();
                    choice1 = findViewById(radioID);
                    int radioID2 = secondSet.getCheckedRadioButtonId();
                    choice2 = findViewById(radioID2);
                    String translateTo = "en";
                    String translateFrom = "es";


                    //get the info from the radioGroups
                    if(choice2.getText().toString().toLowerCase(Locale.ROOT).equals("english"))
                        translateTo = "en";
                    else if(choice2.getText().toString().toLowerCase(Locale.ROOT).equals("spanish"))
                        translateTo = "es";
                    else if(choice2.getText().toString().toLowerCase(Locale.ROOT).equals("german"))
                        translateTo = TranslateLanguage.GERMAN;

                    if(choice1.getText().toString().toLowerCase(Locale.ROOT).equals("english"))
                        translateFrom = "en";
                    else if(choice1.getText().toString().toLowerCase(Locale.ROOT).equals("spanish"))
                        translateFrom = "es";
                    else if(choice1.getText().toString().toLowerCase(Locale.ROOT).equals("german"))
                        translateFrom = TranslateLanguage.GERMAN;

                    //use the translator needed, set it
                    TranslatorOptions options =
                            new TranslatorOptions.Builder()
                                    .setSourceLanguage(translateFrom).setTargetLanguage(translateTo).build();
                    Translator translator = Translation.getClient(options);

                //download translation model
                    DownloadConditions conditions = new DownloadConditions.Builder()
                            .requireWifi()
                            .build();
                    translator.downloadModelIfNeeded(conditions).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(getApplicationContext(), "Download Successful", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Download failed", Toast.LENGTH_SHORT).show();
                        }
                    });

                    //display the translation
                    translator.translate(s).addOnSuccessListener(new OnSuccessListener<String>() {

                                @Override
                                public void onSuccess(@NonNull String str) {
                                    textView.setText(str);
                                }
                            })
                            .addOnFailureListener(
                                    new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            // Error.
                                            // ...
                                        }
                                    });

                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Enter Language", Toast.LENGTH_SHORT).show();
                }
            }
        };

        sharedViewModel.tLang.observe(this, obsver);
    }
}
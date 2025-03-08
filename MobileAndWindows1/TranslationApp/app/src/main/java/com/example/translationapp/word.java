package com.example.translationapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link word#//newInstance} factory method to
 * create an instance of this fragment.
 */
public class word extends Fragment {

    EditText write;
    SharedViewModel sharedViewModel;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public word() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_word, container, false);
        write = view.findViewById(R.id.textInput);
        write.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            //just needs to update sharedViewModel
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sharedViewModel.settLang(write.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        return view;
    }

}
package com.example.translationapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    //gets the word/phrase across the activity and fragment
    MutableLiveData<String> tLang = new MutableLiveData<>("");


    public void settLang(String text) {
        this.tLang.setValue(text);
    }


    public String gettLang() {
        return tLang.getValue();
    }
}

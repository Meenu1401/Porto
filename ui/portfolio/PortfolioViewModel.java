package com.example.myapplication.ui.portfolio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class PortfolioViewModel extends ViewModel {

    private MutableLiveData<String> mText = new MutableLiveData<>("");

    private MutableLiveData<Boolean> result = new MutableLiveData<>();

    public void setmText(MutableLiveData<String> mText) {
        this.mText = mText;
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<Boolean> login(String username, String password) {
        if(username.equalsIgnoreCase("meenu109083@gmail.com") && password.equalsIgnoreCase("1234"))
            result.setValue(true);
        else
            result.setValue(false);
       return result;
    }
}
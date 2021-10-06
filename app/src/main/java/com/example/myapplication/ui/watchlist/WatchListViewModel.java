package com.example.myapplication.ui.watchlist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WatchListViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WatchListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is watchlist fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.example.myapplication.ui.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Items {


    public List<SummaryData> getList() {
        return list;
    }

    public void setList(List<SummaryData> list) {
        this.list = list;
    }

    @SerializedName("Item")
    List<SummaryData> list;
}

package com.example.myapplication.ui.retrofit;

import com.example.myapplication.ui.models.Items;
import com.example.myapplication.ui.models.SummaryData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://myjson.dit.upm.es/api/";

    @GET("bins/e2k5")
    Call<Items> getTopTable();

    @GET("bins/dfet")
    Call<Items> getStockTable();

    @GET("bins/hxg5")
    Call<Items> getMFTable();
}
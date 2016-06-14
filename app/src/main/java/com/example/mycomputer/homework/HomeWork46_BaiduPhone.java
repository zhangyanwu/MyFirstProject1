package com.example.mycomputer.homework;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/6/14.
 */
public interface HomeWork46_BaiduPhone {
    @GET("/apistore/mobilenumber/mobilenumber")
    Call<phone> getPhoneInfo(@Header("apikey") String apikey, @Query("phone") String phoneNumber);
}
package com.example.mycomputer.homework;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/6/12.
 */
public interface gupiaobaidu {
    @GET("/apistore/stockservice/hkstock")
    Call<gupiao> getPhoneInfo(@Header("apikey") String apikey, @Query("stockid") String phoneNumber);
}

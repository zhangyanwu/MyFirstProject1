package com.example.mycomputer.homework;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/6/14.
 */
public class HomeWork46Activity extends BaseActivity {
    EditText phone;
    EditText city;
    @Override
    protected void initContentView(Bundle savedInstanceState) throws IOException {
        setContentView(R.layout.homework46_layout);
        phone = (EditText) findViewById(R.id.phone);
        city = (EditText) findViewById(R.id.city);
    }
    public void findPhoneCity(View view)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HomeWork46_BaiduPhone baidu = retrofit.create(HomeWork46_BaiduPhone.class);
        Call<phone> call = baidu.getPhoneInfo("8e12d0585679836ab5330c18c5ff7209",phone.getText().toString());

        call.enqueue(new Callback<phone>() {
            @Override
            public void onResponse(Call<phone> call, Response<phone> response) {
                phone pc = response.body();
                city.setText(pc.getRetData().getProvince() + "省" + pc.getRetData().getCity() + "市" + pc.getRetData().getSupplier());
            }

            @Override
            public void onFailure(Call<phone> call, Throwable t) {
            }
        });
    }
}


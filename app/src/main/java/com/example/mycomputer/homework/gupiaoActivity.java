package com.example.mycomputer.homework;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/6/12.
 */
public class gupiaoActivity extends BaseActivity {
    EditText et;
    TextView tv;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.gupiaolayout);
        et = (EditText) findViewById(R.id.gp);
        tv = (TextView) findViewById(R.id.cha);
    }

    public void findgupiao(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        gupiaobaidu baidu = retrofit.create(gupiaobaidu.class);
        Call<gupiao> call = baidu.getPhoneInfo("562bafef6007883e2e8fffbbdfa9e6ac", et.getText().toString());
        call.enqueue(new Callback<gupiao>() {
            @Override
            public void onResponse(Call<gupiao> call, Response<gupiao> response) {
                gupiao gp = response.body();
                tv.setTextSize(30);
                tv.setText(gp.getRetData().getStockinfo().getName());
            }
            @Override
            public void onFailure(Call<gupiao> call, Throwable t) {

            }
        });
    }
}

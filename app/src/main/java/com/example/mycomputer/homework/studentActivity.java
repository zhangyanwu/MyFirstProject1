package com.example.mycomputer.homework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/6/12.
 */
public class studentActivity extends Activity {
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lx02_layout);
        et1 = (EditText) findViewById(R.id.edit1);
        et2 = (EditText) findViewById(R.id.edit2);
        et3 = (EditText) findViewById(R.id.edit3);
        et4 = (EditText) findViewById(R.id.btn);
        et4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(studentActivity.this, Getupimg.class);
                startActivityForResult(i, 0);
            }
        });
    }

    public void upimg(View view) {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.1.188:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    student stu = retrofit.create(student.class);
    File file = new File(et4.getText().toString());
    RequestBody requestBody1 =  RequestBody.create(MediaType.parse("multipart/form-data"), file);
    Call<Message> c = stu.uploadStudentInfo(et1.getText().toString(), et2.getText().toString(), et4.getText().toString(), file.getName(),requestBody1 );

        c.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message m = response.body();
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.e("we",t.getMessage());
            }
    });
}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 123){
            String birth = data.getStringExtra("birth");
            et4.setText(birth);
        }
    }
}
package com.example.mycomputer.homework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/2.
 */
public class HomeWork25Activity extends BaseActivity {
    TextView tv;
    Intent i;
    Button btn;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework25_layout);
        tv= (TextView) findViewById(R.id.city);
        btn= (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(HomeWork25Activity.this,HomeWork25_city_Acitivity.class);
                startActivityForResult(i,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode==123)
        {
            String s=data.getStringExtra("sheng");
            String city=data.getStringExtra("city");
            tv.setText(s+city);
            tv.setTextSize(30);
        }
    }
}

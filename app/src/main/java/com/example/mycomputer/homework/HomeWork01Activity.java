package com.example.mycomputer.homework;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by MyComputer on 2016/5/21.
 */
public class HomeWork01Activity extends BaseActivity {

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework01_layout);
    }

    public void show(View view ){
        TextView tv= (TextView) findViewById(R.id.myview);
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        String str=sdf.format(d);
        tv.setText(str);

    }
}

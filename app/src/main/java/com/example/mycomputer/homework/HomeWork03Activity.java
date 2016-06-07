package com.example.mycomputer.homework;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

/**
 * Created by MyComputer on 2016/5/22.
 */
public class HomeWork03Activity extends BaseActivity {
    TextView tv;


    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework03_layout);
        tv= (TextView) findViewById(R.id.mytextview1);
    }
    public void fenbianlv(View view){
        DisplayMetrics dm=new DisplayMetrics();
        dm=getResources().getDisplayMetrics();
        int w=dm.widthPixels;
        int h=dm.heightPixels;
        float d=dm.density;
        int dd=dm.densityDpi;
        tv.setText("你的手机宽为："+w+"\n你的手机高为："+h+"\n你的手机屏幕密度为："+d+"\n你的手机屏幕密度DPI为："+dd);
    }
}

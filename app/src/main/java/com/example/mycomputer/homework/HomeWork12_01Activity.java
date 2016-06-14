package com.example.mycomputer.homework;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/6/13.
 */
public class HomeWork12_01Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HomeWork12_1View a = new HomeWork12_1View(this);
        a.setOnTouchListener(a);
        setContentView(a);
    }
}
package com.example.mycomputer.homework;

import android.os.Bundle;

/**
 * Created by MyComputer on 2016/5/14.
 */
public class HomeWork05Activity extends BaseActivity {
      @Override
    protected void initContentView(Bundle savedInstanceState) {
        HomeWork05View mv =new HomeWork05View(this);
        mv.setOnTouchListener(mv);
        setContentView(mv);
    }
}

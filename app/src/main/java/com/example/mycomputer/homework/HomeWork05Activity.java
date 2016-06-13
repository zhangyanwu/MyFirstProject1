package com.example.mycomputer.homework;

import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Created by MyComputer on 2016/5/14.
 */
public class HomeWork05Activity extends BaseActivity {
    DisplayMetrics dm ;
      @Override
    protected void initContentView(Bundle savedInstanceState) {
          dm = getResources().getDisplayMetrics();
        HomeWork05View mv =new HomeWork05View(this,dm.widthPixels,dm.heightPixels);
        mv.setOnTouchListener(mv);
        setContentView(mv);
    }
}

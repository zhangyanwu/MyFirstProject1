package com.example.mycomputer.homework;

import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Created by MyComputer on 2016/5/28.
 */
public class HomeWork09_01Activity extends BaseActivity {

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        PlaneView p = new PlaneView(this,width,height);
        setContentView(p);
        p.setOnTouchListener(p);
    }
}

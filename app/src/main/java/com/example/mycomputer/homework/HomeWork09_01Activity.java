package com.example.mycomputer.homework;

import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Created by MyComputer on 2016/5/28.
 */
public class HomeWork09_01Activity extends BaseActivity {

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        PlaneView p = new PlaneView(this);
        p.cx = width/2;
        p.cy = height/2;
        setContentView(p);
    }
}

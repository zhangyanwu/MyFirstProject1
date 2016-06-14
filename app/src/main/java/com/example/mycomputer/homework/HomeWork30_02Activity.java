package com.example.mycomputer.homework;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/6/1.
 */
public class HomeWork30_02Activity extends Activity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HomeWork30_02_view view = new HomeWork30_02_view(this);
        view.setOnTouchListener(view);
        setContentView(view);

    }
}

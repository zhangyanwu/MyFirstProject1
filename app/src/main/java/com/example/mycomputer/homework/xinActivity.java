package com.example.mycomputer.homework;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by MyComputer on 2016/6/11.
 */
public class xinActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        xinView view=new xinView(this);
        view.setOnTouchListener(view);
        setContentView(view);
    }
}

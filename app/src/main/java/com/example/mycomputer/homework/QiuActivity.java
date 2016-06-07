package com.example.mycomputer.homework;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by MyComputer on 2016/5/15.
 */
public class QiuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          QiuView qv=new QiuView(this);
          qv.setOnTouchListener(qv);
           setContentView(qv);
    }
}

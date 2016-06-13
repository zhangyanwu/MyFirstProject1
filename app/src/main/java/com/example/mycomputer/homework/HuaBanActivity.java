package com.example.mycomputer.homework;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/6/1.
 */
public class HuaBanActivity extends Activity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HuaBan_view view = new HuaBan_view(this);
        view.setOnTouchListener(view);
        setContentView(view);

    }
}

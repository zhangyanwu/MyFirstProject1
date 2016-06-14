package com.example.mycomputer.homework;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

/**
 * Created by Administrator on 2016/6/13.
 */
public class HomeWork15_2Activity extends BaseActivity {
    String[] arr = {"aaa","aab","aac","abb","bbc","bbd","bca","caa","cdd","ccc"};
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework15_2layout);

        AutoCompleteTextView txt = (AutoCompleteTextView) findViewById(R.id.searchTxt);
        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        txt.setAdapter(ad);
    }
}
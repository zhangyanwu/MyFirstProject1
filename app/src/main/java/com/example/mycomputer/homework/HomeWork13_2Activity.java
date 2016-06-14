package com.example.mycomputer.homework;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/6/13.
 */
public class HomeWork13_2Activity extends BaseActivity{
    String [] s={"java","c","c#","html","jsp"};

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework13_02_layout);
        Spinner ss= (Spinner) findViewById(R.id.xiala);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_list_item_1,s);
        ss.setAdapter(aa);
        ss.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String t="你选择的是"+s[position];
                Toast.makeText(HomeWork13_2Activity.this,t , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
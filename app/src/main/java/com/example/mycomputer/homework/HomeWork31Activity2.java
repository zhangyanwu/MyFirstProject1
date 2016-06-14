package com.example.mycomputer.homework;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.io.IOException;

/**
 * Created by Administrator on 2016/6/14.
 */
public class HomeWork31Activity2 extends BaseActivity{
    CheckBox cb;
    boolean flag=false;
    SharedPreferences sp;

    SharedPreferences.Editor editor;
    @Override
    protected void initContentView(Bundle savedInstanceState) throws IOException {

        setContentView(R.layout.homework31_layout2);
        sp = getSharedPreferences("login",MODE_PRIVATE);
        editor = sp.edit();
        cb= (CheckBox) findViewById(R.id.checkBox);
        cb.setChecked(sp.getBoolean("auto",false));
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flag=isChecked;
            }
        });
    }
    public void aaa(View view){
        editor.putBoolean("auto",true);
        editor.commit();
    }
}

package com.example.mycomputer.homework;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by MyComputer on 2016/5/28.
 */
public class HomeWork11Activity extends BaseActivity {
    RadioGroup rg;

    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    Button bt;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework11_layout);
        rg = (RadioGroup) findViewById(R.id.rg);
        cb1 = (CheckBox) findViewById(R.id.zhuanke);
        cb2 = (CheckBox) findViewById(R.id.benke);
        cb3 = (CheckBox) findViewById(R.id.yanjiusheng);
    }

    public void chakan(View view) {
        String xingbie;
        String xueli = "";

        if (rg.getCheckedRadioButtonId() == R.id.nan) {
            xingbie = "你是男人，";
        } else {
            xingbie = "你是女人，";
        }
        if (cb1.isChecked()) {
            xueli = xueli + "你是专科生。";
        }
        if (cb2.isChecked()) {
            xueli = xueli + "你是本科生。";
        }
        if (cb3.isChecked()) {
            xueli = xueli + "你是研究生。";
        }
        if (xueli.equals("")) {
            xueli = "你没上过学！";
        }
        Toast.makeText(this, xingbie + xueli, Toast.LENGTH_SHORT).show();
    }
}

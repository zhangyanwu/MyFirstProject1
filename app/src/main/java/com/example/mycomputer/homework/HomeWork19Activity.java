package com.example.mycomputer.homework;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by MyComputer on 2016/5/29.
 */
public class HomeWork19Activity extends BaseActivity {
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework19_layout);
        Button dateBn = (Button) findViewById(R.id.dateBn);
        dateBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View source) {
                Calendar c = Calendar.getInstance();
                new DatePickerDialog(HomeWork19Activity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker dp, int year,
                                                  int month, int dayOfMonth) {
                                EditText show = (EditText) findViewById(R.id.show);
                                show.setText("你的生日是：" + year + "年" + (month + 1)
                                        + "月" + dayOfMonth + "日");
                            }
                        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
}

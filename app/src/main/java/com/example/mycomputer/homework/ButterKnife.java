package com.example.mycomputer.homework;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by Administrator on 2016/6/17.
 */
public class ButterKnife extends BaseActivity {
    @BindView(R.id.myview)
    TextView et;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.butterknife_layout);
    }

    @OnClick(R.id.button5)
    public void hello(View view) {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        String str=sdf.format(d);
        et.setText(str);
    }
}

package com.example.mycomputer.homework;

import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

/**
 * Created by MyComputer on 2016/6/7.
 */
public class HomeWork41Activity extends BaseActivity {
    Button btn1, btn2;
    Vibrator vibrator;

    @Override
    protected void initContentView(Bundle savedInstanceState) throws IOException {
        setContentView(R.layout.homework41_layout);
        vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(new long[]{100, 200, 400, 800}, 0);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.cancel();
            }
        });
    }
}

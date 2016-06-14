package com.example.mycomputer.homework;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ViewSwitcher;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/6/14.
 */
public class HomeWork14Activity extends BaseActivity {
    ViewSwitcher vs;
    Timer t;
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            vs.showNext();
        }
    };
    @Override
    protected void initContentView(Bundle savedInstanceState) throws IOException {
        setContentView(R.layout.homework14_layout);
        vs= (ViewSwitcher) findViewById(R.id.switcher);
        HomeWork12_1View a=new HomeWork12_1View(this);
        vs.addView(a);
        HomeWork30_02_view b=new HomeWork30_02_view(this);
        vs.addView(b);

        t=new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Message m=new Message();
                m.what=1;
                h.sendMessage(m);
            }
        },100,3000);
    }
}
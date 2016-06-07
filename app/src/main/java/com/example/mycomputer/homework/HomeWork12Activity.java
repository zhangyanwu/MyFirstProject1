package com.example.mycomputer.homework;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by MyComputer on 2016/5/28.
 */
public class HomeWork12Activity extends BaseActivity {
    Button btn;
    Timer t;
    Handler h=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                btn.setText("点击获取短信验证码");
                btn.setEnabled(true);
                t.cancel();
            }else{
                btn.setText("获取中，请等候"+msg.what+"秒！");
            }
        }
    };

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework12_layout);
        btn = (Button) findViewById(R.id.button31);
    }

    public void huoqu(View view) {
        btn.setEnabled(false);
        t=new Timer();
        t.schedule(new TimerTask() {
            int time=60;
            @Override
            public void run() {
                Message m=new Message();
                m.what=time--;
                h.sendMessage(m);
            }
        },0,1000);
    }
}

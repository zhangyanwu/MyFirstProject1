package com.example.mycomputer.homework;

import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;


/**
 * Created by Administrator on 2016/6/14.
 */
public class HomeWork44Activity extends BaseActivity {
    TelephonyManager telManager;

    SpeechSynthesizer speechSynthesizer;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework44_layout);
        telManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        speechSynthesizer = SpeechSynthesizer.getInstance();
        speechSynthesizer.setContext(this);
        speechSynthesizer.setAppId("8218509");
        speechSynthesizer.setApiKey("m5HVnVSNwzDiTQNPB61qRonC", "5f1d7e13e685ddfc87a2d393aa32529b");
        speechSynthesizer.initTts(TtsMode.ONLINE);

        PhoneStateListener listener = new PhoneStateListener(){
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                switch (state)
                {
                    case TelephonyManager.CALL_STATE_IDLE:
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        break;
                    case TelephonyManager.CALL_STATE_RINGING:
                        speechSynthesizer.speak(incomingNumber+"来电话了！");
                        Toast.makeText(HomeWork44Activity.this, incomingNumber, Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
                super.onCallStateChanged(state, incomingNumber);
            }
        };

        telManager.listen(listener,PhoneStateListener.LISTEN_CALL_STATE);
    }
}
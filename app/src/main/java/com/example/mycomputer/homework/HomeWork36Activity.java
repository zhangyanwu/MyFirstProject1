package com.example.mycomputer.homework;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;

/**
 * Created by Administrator on 2016/6/3.
 */
public class HomeWork36Activity extends BaseActivity {
    EditText et;
    SpeechSynthesizer speechSynthesizer;
    @Override
    protected void initContentView(Bundle savedInstanceState){
        setContentView(R.layout.homework36_layout);
        et = (EditText) findViewById(R.id.editText);
        speechSynthesizer=SpeechSynthesizer.getInstance();
        speechSynthesizer.setContext(this);
        speechSynthesizer.setAppId("8218509");
        speechSynthesizer.setApiKey("m5HVnVSNwzDiTQNPB61qRonC", "5f1d7e13e685ddfc87a2d393aa32529b");
        speechSynthesizer.setParam(SpeechSynthesizer.PARAM_SPEED, "9");
        speechSynthesizer.initTts(TtsMode.ONLINE);
    }
    public void bofang(View view){
        speechSynthesizer.speak(et.getText().toString());
    }
}
package com.example.mycomputer.homework;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

import java.io.IOException;

/**
 * Created by Administrator on 2016/6/14.
 */
public class HomeWork40Activity extends BaseActivity {
    AudioManager am;
    SeekBar sb;
    int f;

    private ServiceConnection con=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void initContentView(Bundle savedInstanceState){
        setContentView(R.layout.homework40_layout);
        if(getIntent().getData()!=null){
            Uri u=getIntent().getData();
            Intent i=new Intent(this,HoneWork40_service.class);
            i.putExtra("name",u.toString());
            bindService(i,con,BIND_AUTO_CREATE);
        }
        am= (AudioManager) getSystemService(Service.AUDIO_SERVICE);
        sb= (SeekBar) findViewById(R.id.seekBar2);
        sb.setProgress(am.getStreamVolume(AudioManager.STREAM_MUSIC));
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress>f){
                    am.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_RAISE,AudioManager.FLAG_SHOW_UI);
                }else{
                    am.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_LOWER,AudioManager.FLAG_SHOW_UI);
                }
                f=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void startplay(View view){
        Intent i=new Intent(this,HoneWork40_service.class);
        i.putExtra("name","/mnt/sdcard/你是我的眼");
        bindService(i,con,BIND_AUTO_CREATE);
    }
    public void stopplay(View view){
        unbindService(con);
    }
}
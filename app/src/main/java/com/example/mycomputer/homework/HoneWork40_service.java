package com.example.mycomputer.homework;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/6/14.
 */
public class HoneWork40_service extends Service {
    MediaPlayer mp;
    mybinder m=new mybinder();
    public class mybinder extends Binder {
        public void setvolume(int i){

        }
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        String s=intent.getStringExtra("name");
        mp=MediaPlayer.create(this, Uri.parse(s));
        mp.start();
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
    }
}
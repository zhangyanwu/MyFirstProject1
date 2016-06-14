package com.example.mycomputer.homework;

import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Administrator on 2016/6/14.
 */
public class HomeWork48Activity extends BaseActivity implements SensorEventListener {
    SensorManager mSensorManager;
    Sensor mSensor;
    int mSpeed=3000;
    int mInterval=50;
    long LastTime;
    float LastX,LastY,LastZ;
    ImageView iv1;
    AnimationDrawable ad;
    @Override
    protected void initContentView(Bundle savedInstanceState) throws IOException {
        setContentView(R.layout.homework48_layout);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        iv1 = (ImageView) findViewById(R.id.animIv);
        ad = (AnimationDrawable) iv1.getBackground();
        ad.setOneShot(true);
        if(mSensorManager!=null) {
            mSensor=mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
        if(mSensor!=null) {
            mSensorManager.registerListener(this, mSensor,SensorManager.SENSOR_DELAY_GAME);
        }
    }
    @Override
    protected void onStop() {
        mSensorManager.unregisterListener(this);
        super.onStop();
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(this);
        super.onPause();
    }
    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {

    }

    @Override
    public void onSensorChanged(SensorEvent Event) {
        long NowTime=System.currentTimeMillis();
        if((NowTime-LastTime)<mInterval)
            return;
        LastTime=NowTime;
        float NowX=Event.values[0];
        float NowY=Event.values[1];
        float NowZ=Event.values[2];
        float DeltaX=NowX-LastX;
        float DeltaY=NowY-LastY;
        float DeltaZ=NowZ-LastZ;
        LastX=NowX;
        LastY=NowY;
        LastZ=NowZ;
        double NowSpeed = Math.sqrt(DeltaX * DeltaX + DeltaY * DeltaY + DeltaZ * DeltaZ)/mInterval * 4000;
        if(!ad.isRunning()){
            if(NowSpeed>=mSpeed) {
                Toast.makeText(HomeWork48Activity.this, "你摇晃了手机！", Toast.LENGTH_SHORT).show();
                ad.start();
                (new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(2000);
                            ad.stop();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }

    }
}
package com.example.mycomputer.homework;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by Administrator on 2016/6/7.
 */
public class HomeWork35_01Activity extends BaseActivity {
    GestureOverlayView gestureView;
    GestureLibrary gestureLibrary;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework35_01_dialog_layout);
        gestureLibrary = GestureLibraries.fromFile("/mnt/sdcard/mygestures");
        if (gestureLibrary.load()) {
            Toast.makeText(HomeWork35_01Activity.this, "手势加载成功!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(HomeWork35_01Activity.this, "手势加载失败！", Toast.LENGTH_SHORT).show();
        }
        gestureView = (GestureOverlayView) findViewById(R.id.gesture);
        gestureView.addOnGesturePerformedListener(
                new GestureOverlayView.OnGesturePerformedListener() {
                    @Override
                    public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
                        ArrayList<Prediction> predictions = gestureLibrary.recognize(gesture);
                        for (Prediction p:predictions)
                        {
                            if(p.score>2.0){

                            }
                        }
                    }
                }
        );
    }
}

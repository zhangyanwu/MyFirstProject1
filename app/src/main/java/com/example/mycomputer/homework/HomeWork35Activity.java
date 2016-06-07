package com.example.mycomputer.homework;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;

/**
 * Created by Administrator on 2016/6/6.
 */
public class HomeWork35Activity extends BaseActivity {
    EditText editText;
    GestureOverlayView gestureView;

    @Override
    protected void initContentView(Bundle savedInstanceState) throws IOException {
        setContentView(R.layout.homework35_layout);
        editText = (EditText) findViewById(R.id.gesture_name);
        gestureView = (GestureOverlayView) findViewById(R.id.gesture);
        gestureView.setGestureStrokeWidth(5);
        gestureView.setGestureColor(Color.BLUE);
        gestureView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView gestureOverlayView, final Gesture gesture) {
                View saveDialog = getLayoutInflater().inflate(R.layout.homework35_dialog_layout, null);
                ImageView imageView = (ImageView) saveDialog.findViewById(R.id.show);
                final EditText gestureName = (EditText) saveDialog.findViewById(R.id.gesture_name);
                Bitmap bitmap = gesture.toBitmap(130, 130, 10, 0xffff0000);
                imageView.setImageBitmap(bitmap);
                new AlertDialog.Builder(HomeWork35Activity.this)
                        .setView(saveDialog)
                        .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                GestureLibrary gestureLib = GestureLibraries
                                        .fromFile("/mnt/sdcard/mygestures");
                                gestureLib.addGesture(gestureName.getText().toString(), gesture);
                                gestureLib.save();
                            }
                        }).setNegativeButton("取消", null).show();
            }
        });
    }
}

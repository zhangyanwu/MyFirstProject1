package com.example.mycomputer.homework;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by MyComputer on 2016/6/5.
 */
public class HomeWork34Activity extends BaseActivity implements GestureDetector.OnGestureListener {
    ImageView iv;
    int[] i = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};
    int n = 0;
    GestureDetector detector;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework34_layout);
        iv = (ImageView) findViewById(R.id.myimg);
        iv.setImageResource(i[n]);
        detector = new GestureDetector(this, this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float x1 = e1.getX();
        float x2 = e2.getX();
        if (x2 - x1 >= 50) {
            if (n == 0) {
                AlertDialog b = new AlertDialog.Builder(this)
                        .setTitle("对话框")
                        .setIcon(R.drawable.icon_11)
                        .setMessage("没有上一张了！")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(HomeWork34Activity.this, "你点确定了！", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                b.show();
            }
            if (n > 0) {
                iv.setImageResource(i[--n]);
            }
        }
        else if (x1-x2>=50){
            if (n==i.length-1){
                AlertDialog b = new AlertDialog.Builder(this)
                        .setTitle("对话框")
                        .setIcon(R.drawable.icon_11)
                        .setMessage("没有下一张了！")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(HomeWork34Activity.this, "你点确定了！", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                b.show();
            }
            if (n<i.length-1){
                iv.setImageResource(i[++n]);
            }
        }
            return true;
    }
}

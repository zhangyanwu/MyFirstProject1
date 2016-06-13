package com.example.mycomputer.homework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyComputer on 2016/5/14.
 */
public class HomeWork05View extends View implements View.OnTouchListener {

    public float xx = 300;
    public float yy = 300;

    Bitmap bitmap;
    Canvas tempc;
    Paint tempp;


    public HomeWork05View(Context context, int width, int height) {
        super(context);

        tempc = new Canvas();
        tempp = new Paint();
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        tempc.setBitmap(bitmap);
    }

    public HomeWork05View(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        canvas.drawBitmap(bitmap, 0, 0, p);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            xx = event.getX();
            yy = event.getY();
            HomeWork05Point p = new HomeWork05Point();
            p.setX(xx);
            p.setY(yy);
            int color = 0xff000000 + (int) (Math.random() * 0xffffff);
            p.setColor(color);
            HomeWork05Point point = p;
            tempp.setAntiAlias(true);
            tempp.setStrokeWidth(10);
            tempp.setColor(point.getColor());
            for (float i = -2; i <= 2; i += 0.01) {
                float y = (float) Math.sqrt(2 * Math.sqrt(i * i) - i * i);
                float y2 = (float) (-2.14 * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(i))));

                tempc.drawPoint(i * 100 + point.getX(), -y * 100 + point.getY(), tempp);
                tempc.drawPoint(i * 100 + point.getX(), -y2 * 100 + point.getY(), tempp);
                tempc.drawPoint(i * 50 + point.getX(), -y * 50 + point.getY(), tempp);
                tempc.drawPoint(i * 50 + point.getX(), -y2 * 50 + point.getY(), tempp);
            }
            invalidate();
        }
        return true;
    }
}

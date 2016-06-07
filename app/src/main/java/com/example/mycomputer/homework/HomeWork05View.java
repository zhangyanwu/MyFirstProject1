package com.example.mycomputer.homework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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

    List<HomeWork05Point> list = new ArrayList<HomeWork05Point>();


    public HomeWork05View(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setAntiAlias(true);
        p.setStrokeWidth(8);

        for (HomeWork05Point point : list) {
            p.setColor(point.getColor());
            for (float x = -2; x <= 2; x += 0.01) {
                float y = (float) Math.sqrt(2 * Math.sqrt(x * x) - x * x);
                float y1 = (float) (-2.14 * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(x))));
                canvas.drawPoint(x * 100 + point.getX(), -y * 100 + point.getY(), p);
                canvas.drawPoint(x * 100 + point.getX(), -y1 * 100 + point.getY(), p);
                canvas.drawPoint(x * 50 + point.getX(), -y * 50 + point.getY(), p);
                canvas.drawPoint(x * 50 + point.getX(), -y1 * 50 + point.getY(), p);

            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            xx = event.getX();
            yy = event.getY();
            HomeWork05Point point=new HomeWork05Point();
            point.setX(xx);
            point.setY(yy);
            int color = 0xff000000+(int) (Math.random()*0xffffff);
            point.setColor(color);
            list.add(point);
            invalidate();
        }
            return true;
        }
}

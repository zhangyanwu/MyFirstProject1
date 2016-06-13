package com.example.mycomputer.homework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by MyComputer on 2016/6/11.
 */
public class xinView extends View implements View.OnTouchListener {
    DisplayMetrics dm;
    Canvas tcanvas;
    Paint p;
    Bitmap bitmap;

    float startX;
    float startY;

    public xinView(Context context) {
        super(context);
        dm = getResources().getDisplayMetrics();
        bitmap = Bitmap.createBitmap(dm.widthPixels,dm.heightPixels, Bitmap.Config.ARGB_8888);
        tcanvas = new Canvas();
        p = new Paint();
        p.setColor(Color.RED);
        p.setStrokeWidth(5);
        tcanvas.setBitmap(bitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint p1=new Paint();
        canvas.drawBitmap(bitmap,0,0,p1);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                startY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                tcanvas.drawLine(startX, startY, event.getX(), event.getY(), p);
                startX = event.getX();
                startY = event.getY();
                invalidate();
                break;
        }
        return true;
    }
}

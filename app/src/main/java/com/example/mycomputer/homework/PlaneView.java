package com.example.mycomputer.homework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by MyComputer on 2016/5/28.
 */
public class PlaneView extends View implements View.OnTouchListener {

    float cx;
    float cy;

    float xx;
    float yy;
    Bitmap bm;

    public PlaneView(Context context) {
        super(context);
        bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.planelogo);
        setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        canvas.drawBitmap(bm, cx, cy, p);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x=event.getX();
        float y=event.getY();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(!(x>=cx && x<=cx+bm.getWidth()) || !(y>=cy && y<=cy+bm.getHeight()))
                {
                    return true;
                }
                cx=x-xx-48;
                cy=y-cy-61;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_CANCEL:
                cx = x - xx-48;
                cy = y - yy-61;
                invalidate();
        }
        return true;
    }
}

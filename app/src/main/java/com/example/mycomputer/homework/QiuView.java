package com.example.mycomputer.homework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by MyComputer on 2016/5/15.
 */
public class QiuView extends View implements View.OnTouchListener{



    float x=360;
    float y=640;
    float k= (float) (Math.random()-0.5);

    public QiuView(Context context) {
        super(context);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p=new Paint();
        p.setColor(Color.RED);
        p.setAntiAlias(true);
        p.setStrokeWidth(5);
        canvas.drawCircle(x,y,15,p);




    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        for (x=360;x<=720-15;x+=0.1)
        {
            y=k*x;
            invalidate();
        }
//        if (x==360){
//
//        }

        return false;
    }
}

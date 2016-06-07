package com.example.mycomputer.homework;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by MyComputer on 2016/6/4.
 */
public class HomeWork33Activity extends BaseActivity implements GestureDetector.OnGestureListener {
    GestureDetector detector;
    ImageView iv;
    Matrix matrix;
    Bitmap bitmap;
    int width;
    int height;
    float bili = 1;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework33_layout);
        detector = new GestureDetector(this, this);
        iv = (ImageView) findViewById(R.id.myimg);
        matrix = new Matrix();
        bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.img1);
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        iv.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.img1));
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

        if (velocityX>0) {
            bili = (float) (bili*2+0.01);
            matrix.reset();
            matrix.setScale(bili, bili, 160, 200);
            BitmapDrawable tmp = (BitmapDrawable) iv.getDrawable();
            if (!tmp.getBitmap().isRecycled()) {
                tmp.getBitmap().recycle();
            }
            Bitmap b = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            iv.setImageBitmap(b);
        }if(velocityX<0){
            if (bili<=0){
                bili= (float) 0.01;
            }else {
                bili = (float) (bili/2 - 0.01);
            }
            matrix.reset();
            matrix.setScale(bili, bili, 160, 200);
            BitmapDrawable tmp = (BitmapDrawable) iv.getDrawable();
            if (!tmp.getBitmap().isRecycled()) {
                tmp.getBitmap().recycle();
            }
            Bitmap b = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            iv.setImageBitmap(b);
        }
        return true;
    }
}

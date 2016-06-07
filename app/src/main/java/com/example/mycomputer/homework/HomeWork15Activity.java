package com.example.mycomputer.homework;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/5/17.
 */
public class HomeWork15Activity extends BaseActivity {

    public int[] a = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};
    public int i = 0;
    int alpha = 255;
    ImageView imgView;
    ImageView imgView2;

     @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework15_layout);
        imgView= (ImageView) findViewById(R.id.myimage);
         imgView2= (ImageView) findViewById(R.id.imageView7);
         imgView.setImageResource(a[0]);
    }

    public void last(View view){
        imgView.setImageResource(a[Math.abs(--i)%5]);


    }
    public void next(View view){
        imgView.setImageResource(a[Math.abs(++i)%5]);

    }
    public void jia(View view){
        alpha+=10;
        if(alpha > 255){
            imgView.setImageAlpha(255);
            alpha = 255;
        }else{
            imgView.setImageAlpha(alpha);
        }

    }
    public void jian(View view){
        alpha-=10;
        if(alpha < 0){
            imgView.setImageAlpha(0);
            alpha=0;
        }else{
            imgView.setImageAlpha(alpha);
        }
   imgView.setOnTouchListener(new View.OnTouchListener() {
       @Override
       public boolean onTouch(View v, MotionEvent event) {
           BitmapDrawable bitmapDrawable= (BitmapDrawable) imgView.getDrawable();
           Bitmap bitmap=bitmapDrawable.getBitmap();
           double scale=1.0*bitmap.getHeight()/imgView.getHeight();
           int x= (int) (event.getX()*scale);
           int y= (int) (event.getY()*scale);
           if(x>bitmap.getWidth()-150) {
               x = bitmap.getWidth() - 150;
           }
           if(y>bitmap.getHeight()-150){
               y=bitmap.getHeight()-150;
           }
           imgView2.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,150,150));
           imgView2.setImageAlpha(alpha);
           return true;
       }
   });
    }
}

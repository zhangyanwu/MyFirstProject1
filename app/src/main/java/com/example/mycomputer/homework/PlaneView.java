package com.example.mycomputer.homework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;
import java.util.Vector;

/**
 * Created by MyComputer on 2016/5/28.
 */
public class PlaneView extends View implements View.OnTouchListener {
    float cx;
    float cy;
    float ax;
    float ay;
    float dx;
    float dy;
    Bitmap airplane;
    Bitmap background;
    Bitmap enemy;
    Bitmap boom;
    BitmapDrawable bd;
    AnimationDrawable ad;
    Drawable da;
    boolean flag = true;
    boolean flag2 = false;

    List<zidan_bean> list = new Vector<zidan_bean>();
    List<diji_bean> list2 = new Vector<diji_bean>();

    Handler h = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            invalidate();
        }
    };


    public PlaneView(Context context,int width,int height) {
        super(context);
        Bitmap a = BitmapFactory.decodeResource(getResources(), R.drawable.planelogo);
        Matrix m1=new Matrix();
        m1.setScale(0.7f,0.7f);
        airplane=Bitmap.createBitmap(a,0,0,a.getWidth(),a.getHeight(),m1,false);
        background=BitmapFactory.decodeResource(getResources(),R.drawable.back);
        Bitmap b=BitmapFactory.decodeResource(getResources(),R.drawable.planelogo);
        Matrix m2=new Matrix();
        m2.setRotate(180);
        Bitmap bb=Bitmap.createBitmap(b,0,0,b.getWidth(),b.getHeight(),m2,false);
        Matrix m3=new Matrix();
        m3.setScale(0.5f,0.5f);
        enemy=Bitmap.createBitmap(bb,0,0,b.getWidth(),b.getHeight(),m3,false);
        boom=BitmapFactory.decodeResource(getResources(),R.drawable.donghua);
        cx = width / 2 - airplane.getWidth() / 2;
        cy = height;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        canvas.drawBitmap(airplane, cx, cy, p);

        if(list!=null&&list2!=null) {
            for(int i=list.size()-1;i>=0;i--){
                for(int ii=list2.size()-1;ii>=0;ii--){
                    Float bulletx=list.get(i).getX();
                    Float bullety=list.get(i).getY();
                    Float enemyx=list2.get(ii).getX();
                    Float enemyy=list2.get(ii).getY();
                    if (bulletx>enemyx&&bulletx<enemyx+enemy.getWidth()){
                        if(bullety<enemyy+enemy.getHeight()&&bullety>enemyy){
                            list.remove(i);
                            list2.remove(ii);
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                p.setColor(0xff000000);
                canvas.drawRect(list.get(i).getX() - 5, list.get(i).getY() - 20, list.get(i).getX() + 5, list.get(i).getY() + 20, p);
            }
            for(int ii=0;ii<list2.size();ii++){
                canvas.drawBitmap(enemy,list2.get(ii).getX(),list2.get(ii).getY(),p);
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        ax = event.getX();
        ay = event.getY();
        if(flag){
            flag=false;
            (new Thread() {
                @Override
                public void run() {
                    super.run();
                    while (cy > 1500) {
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        cy -= 5;
                        Message m = new Message();
                        m.what = 1;
                        h.sendMessage(m);
                    }
                    flag2=true;
                }
            }).start();
        }

        if (flag2) {
            flag2 = false;

            (new Thread() {
                @Override
                public void run() {
                    super.run();
                    while (true) {
                        if (list!= null) {
                            for (int i = 0; i < list.size(); i++) {
                                float y = list.get(i).getY();
                                list.get(i).setY(y - 20);
                                if (y < 0) {
                                    list.remove(i);
                                }
                            }
                        }
                        if(list2.size()!=0){
                            for(int ii=0;ii<list2.size();ii++){
                                float y=list2.get(ii).getY();
                                list2.get(ii).setY(y+10);
                                if(y>1950){
                                    list2.remove(ii);
                                }
                            }
                        }
                        Message m = new Message();
                        m.what = 1;
                        h.sendMessage(m);
                        try {
                            sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
            (new Thread() {
                @Override
                public void run() {
                    super.run();
                    while (true) {
                        zidan_bean bb = new zidan_bean();
                        bb.setX(cx + (airplane.getWidth()/2));
                        bb.setY(cy - 50);
                        list.add(bb);
                        try {
                            sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
            (new Thread(){
                @Override
                public void run() {
                    super.run();
                    int x;
                    while (true){
                        diji_bean eb=new diji_bean();
                        x=(int)(Math.random()*1080);
                        eb.setX(x-enemy.getWidth()/2);
                        eb.setY(-100);
                        list2.add(eb);
                        try {
                            sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            dx = ax - cx;
            dy = ay - cy;
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            cx = ax - dx;
            cy = ay - dy;
        }
        return true;
    }
}
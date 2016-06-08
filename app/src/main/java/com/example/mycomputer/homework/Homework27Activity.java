package com.example.mycomputer.homework;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by Administrator on 2016/6/2.
 */
public class HomeWork27Activity extends BaseActivity {
    ImageView show;
    EditText et;
    EditText et1;
    InputStream is;
    Bitmap bitmap;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 123) {
                show.setImageBitmap(bitmap);
            }
        }
    };
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework27_layout);
        show = (ImageView) findViewById(R.id.show);
        et = (EditText) findViewById(R.id.myet);
        et1 = (EditText) findViewById(R.id.myet1);
    }

    public void download(View view) {
        if (et.getText().toString().equals("")) {
            AlertDialog b = new AlertDialog.Builder(this)
                    .setTitle("提示框")
                    .setIcon(R.drawable.icon_11)
                    .setMessage("请输入图片的网址！")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(HomeWork27Activity.this, "你确定了！", Toast.LENGTH_SHORT).show();
                        }
                    }).create();
            b.show();
        } else if (et1.getText().toString().equals("")) {
            AlertDialog b = new AlertDialog.Builder(this)
                    .setTitle("提示框")
                    .setIcon(R.drawable.icon_11)
                    .setMessage("请输入保存图片的名字！")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(HomeWork27Activity.this, "你确定了！", Toast.LENGTH_SHORT).show();
                        }
                    }).create();
            b.show();
        } else {
            (new Thread() {
                @Override
                public void run() {
                    try {
                        URL url = new URL(et.getText().toString());
                        is = url.openStream();
                        OutputStream os = openFileOutput(et1.getText().toString() + ".jpg", MODE_APPEND);
                        byte[] buff = new byte[1024];
                        int h = 0;
                        while ((h = is.read(buff)) > 0) {
                            os.write(buff, 0, h);
                        }
                        is.close();
                        os.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    super.run();
                }
            }).start();
        }
    }

    public void open(View view) {
        (new Thread() {
            @Override
            public void run() {

                try {
                    InputStream is=openFileInput(et1.getText().toString()+".jpg");
                    bitmap = BitmapFactory.decodeStream(is);
                    handler.sendEmptyMessage(123);
                    is.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                super.run();
            }


        }).start();
    }


}

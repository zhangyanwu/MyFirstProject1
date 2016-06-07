package com.example.mycomputer.homework;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by MyComputer on 2016/5/14.
 */
public class HomeWork04Activity extends BaseActivity {

    int[] i={R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5 };
     int num=0;



    @Override
    protected void initContentView(Bundle savedInstanceState) {

        setContentView(R.layout.homework04_layout);

        final ImageView iv= (ImageView) findViewById(R.id.img);
        iv.setImageResource(i[0]);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iv.setImageResource(i[(++num)%5]);

            }
        });
    }
}

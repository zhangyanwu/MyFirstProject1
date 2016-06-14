package com.example.mycomputer.homework;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by MyComputer on 2016/5/29.
 */
public class HomeWork13_3Activity extends BaseActivity {

    int[] img = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};
    AdapterViewFlipper avf;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework13_03_layout);
        avf = (AdapterViewFlipper) findViewById(R.id.myavf);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return img.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView = new ImageView(HomeWork13_3Activity.this);
                imageView.setImageResource(img[position]);
                return imageView;
            }
        };
        avf.startFlipping();
        avf.setAdapter(adapter);
        avf.setFlipInterval(3000);
    }

    public void shang(View view) {
        avf.showPrevious();
        avf.stopFlipping();
    }

    public void xia(View view) {
        avf.showNext();
        avf.stopFlipping();
    }

    public void auto(View view) {
        avf.startFlipping();
    }
}

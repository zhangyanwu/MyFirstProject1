package com.example.mycomputer.homework;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by MyComputer on 2016/5/29.
 */
public class HomeWork16Activity extends BaseActivity {
    ListView listView;
    String[] food = {"红烧肉", "溜肉段", "四喜丸子", "干煸芸豆", "大葱蘸酱"};
    int[] img = {R.drawable.icon_11, R.drawable.icon_16, R.drawable.icon_18, R.drawable.icon_28, R.drawable.icon_30};

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework16_layout);
        listView = (ListView) findViewById(R.id.mylist);
        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return food.length;
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
                LinearLayout line = new LinearLayout(HomeWork16Activity.this);
                ImageView image = new ImageView(HomeWork16Activity.this);
                TextView tv = new TextView(HomeWork16Activity.this);
                tv.setText(food[position]);
                tv.setTextSize(20);
                image.setImageResource(img[position]);
                line.addView(image);
                line.addView(tv);
                return line;
            }
        };
        listView.setAdapter(baseAdapter);
    }
}

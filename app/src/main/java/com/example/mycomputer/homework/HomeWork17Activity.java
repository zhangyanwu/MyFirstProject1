package com.example.mycomputer.homework;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MyComputer on 2016/5/29.
 */
public class HomeWork17Activity extends BaseActivity {
    GridView gridView;
    List<Map<String ,Object>> list = new ArrayList<Map<String , Object>>();
    int[] img ={R.drawable.icon_11, R.drawable.icon_16, R.drawable.icon_18, R.drawable.icon_28, R.drawable.icon_30, R.drawable.icon_33};
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework17_layout);
        gridView= (GridView) findViewById(R.id.gridView);
        for (int i=0;i<img.length;i++)
        {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("image",img[i]);
            list.add(map);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list, R.layout.img_layout,new String[]{"image"},new int[]{R.id.image});
      gridView.setAdapter(simpleAdapter);
    }
}

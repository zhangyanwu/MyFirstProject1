package com.example.mycomputer.homework;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/2.
 */
public class HomeWork25_city_Acitivity extends Activity {
    String[] s={"辽宁省","吉林省","黑龙江省"};
    String[][] c={{"沈阳","大连","鞍山"},{"长春市","四平市","公主岭"},{"哈尔滨市","大庆市","齐齐哈尔市"}};
   ExpandableListView elv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
        setContentView(R.layout.homework25_city_layout);
        elv= (ExpandableListView) findViewById(R.id.city);
        ExpandableListAdapter e=new ExpandableListAdapter() {
            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getGroupCount() {
                return s.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return c[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return s[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return c[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                TextView v=new TextView(HomeWork25_city_Acitivity.this);
                v.setText(s[groupPosition]);
                v.setTextSize(30);
                v.setPadding(40,0,0,0);
                return v;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView v=new TextView(HomeWork25_city_Acitivity.this);
                v.setText(c[groupPosition][childPosition]);
                v.setTextSize(20);
                v.setPadding(40,0,0,0);
                return v;
            }
            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int groupPosition) {
            }
            @Override
            public void onGroupCollapsed(int groupPosition) {
            }
            @Override
            public long getCombinedChildId(long groupId, long childId) {
                return 0;
            }

            @Override
            public long getCombinedGroupId(long groupId) {
                return 0;
            }
        };
        elv.setAdapter(e);
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent i = getIntent();
                i.putExtra("city",c[groupPosition][childPosition]);
                i.putExtra("sheng",s[groupPosition]);
                setResult(123,i);
                finish();
                return true;
            }
        });
    }
}

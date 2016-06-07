package com.example.mycomputer.homework;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

/**
 * Created by MyComputer on 2016/5/28.
 */
public class HomeWork13Activity extends BaseActivity {
    private String[] a = {"动画片", "电视剧", "电影", "综艺"};
    private String[][] b = {{"葫芦娃", "猫和耗子", "蜡笔小新", "喜羊羊和灰太狼"}, {"西游记", "三国演义", "水浒传", "红楼梦"}, {"地雷战", "地道战", "小兵张嘎", "三毛行军记"}, {"快乐大本营", "liao吧，哥们！", "极限挑战", "欢乐喜剧人"}};

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework13_layout);
        ExpandableListAdapter ela = new ExpandableListAdapter() {
            @Override
            public void registerDataSetObserver(DataSetObserver observer) {
            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {
            }

            @Override
            public int getGroupCount() {return a.length;}

            @Override
            public int getChildrenCount(int groupPosition) {
                return b[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return b[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return b[groupPosition][childPosition];
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

                LayoutInflater li=LayoutInflater.from(HomeWork13Activity.this);
                View v=li.inflate(android.R.layout.simple_list_item_1,null);
                TextView tv= (TextView) v.findViewById(android.R.id.text1);
                tv.setPadding(90,0,0,0);
                tv.setText(a[groupPosition]);
                return v;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView tv = new TextView(HomeWork13Activity.this);
                tv.setTextSize(20);
                tv.setText("             "+b[groupPosition][childPosition]);
                return tv;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return false;
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
                return groupId;
            }

            @Override
            public long getCombinedGroupId(long groupId) {
                return groupId;
            }
        };
        ExpandableListView view= (ExpandableListView) findViewById(R.id.expandableListView);
        view.setAdapter(ela);
    }
}

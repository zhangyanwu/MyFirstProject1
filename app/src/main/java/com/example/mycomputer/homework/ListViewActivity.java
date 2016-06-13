package com.example.mycomputer.homework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/5/30.
 */
public class ListViewActivity extends BaseActivity {
    String[] names = {"作业1：hello world!", "作业2：放一个图片", "作业3：手机信息及dpi", "作业4：点击图片循环", "作业5：点击处画心",
            "作业6：布局6-1", "作业6：布局6-2", "作业6：布局6-3", "作业7：霓虹灯", "作业8:布局十字架",
            "作业9：布局计算器", "作业9-1：飞机拖拽", "作业9-2：图片连接通讯录", "作业10：布局10-1", "作业10：布局10-2",
            "作业11：radio选中，Toast提示", "作业12：验证码，60秒不能点击", "作业12-2：手机归属地", "作业13：布局", "作业14：自动播放图片",
            "作业15：局部显示图片", "作业16：展示ListView", "作业17：GridView显示两列商品", "作业18： 搜索框下方listview对应", "作业19：选择生日，显示在EditText中",
            "作业20：Tab三个选项卡", "作业23：Dialog对话框", "作业23-1：国际化", "作业24：打电话发短信", "作业24-1：百度",
            "作业25：省份所在城市", "作业26：横竖屏转换", "下载", "作业30-1：爆炸加声音", "作业32-01：SD卡浏览",
            "作业33：放大缩小图片", "作业34：左右滑换页","百度语音TTS"};
    Class[] cl = {HomeWork01Activity.class, HomeWork02Activity.class, HomeWork03Activity.class, HomeWork04Activity.class, HomeWork05Activity.class,
            HomeWork06_01Activity.class, HomeWork06_02Activity.class, HomeWork06_03Activity.class, HomeWork07Activity.class, HomeWork08Activity.class,
            HomeWork09Activity.class, HomeWork09_01Activity.class, HomeWork09_02Activity.class, HomeWork10_01Activity.class, HomeWork10_02Activity.class,
            HomeWork11Activity.class, HomeWork12Activity.class, HomeWork12_02Activity.class, HomeWork13Activity.class, HomeWork14Activity.class,
            HomeWork15Activity.class, HomeWork16Activity.class, HomeWork17Activity.class, HomeWork18Activity.class, HomeWork19Activity.class,
            HomeWork20Activity.class, HomeWork23Activity.class, HomeWork23_01Activity.class, HomeWork24Activity.class, HomeWork24_01Activity.class,
            HomeWork25Activity.class, HomeWork26Activity.class, HomeWork27Activity.class, HomeWork30_03Activity.class, HomeWork32_01Activity.class,
            HomeWork33Activity.class, HomeWork34Activity.class, HomeWork36Activity.class};
    ListView listView;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.listview_layout);
        listView = (ListView) findViewById(R.id.mylistview);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(aa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ListViewActivity.this, cl[position]);
                startActivity(i);
            }
        });
    }
}

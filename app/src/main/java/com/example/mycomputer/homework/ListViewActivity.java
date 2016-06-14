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
    String[] names = {"作业1：hello world!", "作业2：放一个图片", "作业3：手机信息及dpi", "作业4：点击图片循环", "作业5：双缓冲画心",
            "作业6：布局6-1", "作业6：布局6-2", "作业6：布局6-3", "作业7：霓虹灯", "作业8：布局十字架",
            "作业9：布局计算器", "作业9-1：飞机拖拽", "作业9-2：布局", "作业10：布局10-1", "作业10：布局10-2",
            "作业11：radio练习，Toast显示", "作业12：短信验证码60秒",
            "作业12-1：弹球游戏", "作业12-2：百度API查询手机归属地", "作业13：模仿qq布局",
            "作业13-2：下拉列表", "作业13-4：列表点击跳转详情", "作业14：自动播放图片3秒换",
            "作业15：局部显示图片", "作业15-2：自动搜索",
            "作业16：ListView展示列表", "作业17：GridView 分两列显示商品", "作业18：搜索框，下面listView ",
            "作业19：edittext里显示选择的日期", "作业20：Tabhost 三个选项卡", "作业22：菜单练习",
            "作业23：Dialog弹出框", "作业23-3：国际化", "作业24及24-1及30：打电话，发短信，获取联系人，百度", "作业25：级联菜单选择省份", "作业26：横竖屏",
            "作业27：下载", "作业28：手机及平板适配", "作业30-2：画板", "作业30-3：逐帧动画", "作业31：自动登录", "作业32：数据库操作",
            "作业32-1：SD卡浏览器可打开jpg图片", "作业33：图片放大缩小",
            "作业34：左右滑换页", "作业35：添加手势", "作业35-1：通过作业35添加的手势回桌面",
            "作业36：百度语音", "作业38：短信群发", "作业40：播放音乐",
            "作业41：震动", "作业42：闹钟", "作业44：电话拦截", "作业46：网络共享api", "作业47：指南针", "作业48：摇一摇", "作业：股票",
            "作业：播放视频"};
    Class[] cl = {HomeWork01Activity.class, HomeWork02Activity.class, HomeWork03Activity.class, HomeWork04Activity.class, HomeWork05Activity.class,
            HomeWork06_01Activity.class, HomeWork06_02Activity.class, HomeWork06_03Activity.class, HomeWork07Activity.class, HomeWork08Activity.class,
            HomeWork09Activity.class, HomeWork09_01Activity.class, HomeWork09_02Activity.class, HomeWork10_01Activity.class, HomeWork10_02Activity.class,
            HomeWork11Activity.class, HomeWork12Activity.class,
            HomeWork12_01Activity.class, HomeWork12_02Activity.class, HomeWork13Activity.class,
            HomeWork13_2Activity.class, HomeWork13_4Activity.class, HomeWork14Activity.class,
            HomeWork15Activity.class, HomeWork15_2Activity.class,
            HomeWork16Activity.class, HomeWork17Activity.class, HomeWork18Activity.class,
            HomeWork19Activity.class, HomeWork20Activity.class, HomeWork22Activity.class,
            HomeWork23Activity.class, HomeWork23_03Activity.class, HomeWork24Activity.class, HomeWork25Activity.class, HomeWork26Activity.class,
            HomeWork27Activity.class, HomeWork28Activity.class, HomeWork30_02Activity.class, HomeWork30_03Activity.class, HomeWork31Activity.class, HomeWork32Activity.class,
            HomeWork32_01Activity.class, HomeWork33Activity.class,
            HomeWork34Activity.class, HomeWork35Activity.class, HomeWork35_01Activity.class,
            HomeWork36Activity.class, HomeWork38Activity.class, HomeWork40Activity.class,
            HomeWork41Activity.class, HomeWork42Activity.class, HomeWork44Activity.class, HomeWork46Activity.class, HomeWork47Activity.class, HomeWork48Activity.class, gupiaoActivity.class,
            VideoViewActivity.class};
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

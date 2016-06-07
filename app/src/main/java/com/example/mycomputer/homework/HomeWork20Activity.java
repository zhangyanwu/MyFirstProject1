package com.example.mycomputer.homework;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by MyComputer on 2016/5/29.
 */
public class HomeWork20Activity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework20_layout);
        TabHost host=getTabHost();
        TabHost.TabSpec tab1=host.newTabSpec("tab1").setIndicator("拨号").setContent(R.id.tab1);
        host.addTab(tab1);
        TabHost.TabSpec tab2 = host.newTabSpec("tab2").setIndicator("联系人").setContent(R.id.tab2);
        host.addTab(tab2);
        TabHost.TabSpec tab3 = host.newTabSpec("tab3").setIndicator("什么玩意").setContent(R.id.tab3);
        host.addTab(tab3);
    }
}

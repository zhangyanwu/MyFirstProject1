package com.example.mycomputer.homework;

import android.os.Bundle;
import android.widget.QuickContactBadge;

/**
 * Created by MyComputer on 2016/5/28.
 */
public class HomeWork09_02Activity extends BaseActivity {
    QuickContactBadge qcb;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework09_03_layout);
        qcb= (QuickContactBadge) findViewById(R.id.quickContactBadge);
        qcb.assignContactFromPhone("15040138915",true);
    }
}

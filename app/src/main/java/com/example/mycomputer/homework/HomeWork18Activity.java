package com.example.mycomputer.homework;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

/**
 * Created by MyComputer on 2016/5/29.
 */
public class HomeWork18Activity extends BaseActivity {
    String[] str = {"aqqq", "awww", "bqqq", "bwww", "cqqq", "cwww"};
    SearchView sv;
    ListView lv;

    @Override
    protected void initContentView(Bundle savedInstanceState) {

        setContentView(R.layout.homework18_layout);
        lv = (ListView) findViewById(R.id.listview);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str));
        lv.setTextFilterEnabled(true);
        sv = (SearchView) findViewById(R.id.sv);
        sv.setIconifiedByDefault(true);
        sv.setSubmitButtonEnabled(true);
        sv.setQueryHint("查找");
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(HomeWork18Activity.this,"你输入的是："+query,Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)){
                    lv.clearTextFilter();
                }else {
                    lv.setFilterText(newText);
                }
                return true;
            }
        });
    }
}

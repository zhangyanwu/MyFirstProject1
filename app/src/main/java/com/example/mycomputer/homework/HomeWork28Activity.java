package com.example.mycomputer.homework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class HomeWork28Activity extends Activity implements HomeWork28BookListFragment.Callback{
    boolean twoPan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework28_layout);

        if(findViewById(R.id.book_detail_container)!=null)
        {
            twoPan = true;
        }
    }


    @Override
    public void onItemSelected(Integer id) {
       if(twoPan)
       {
           Bundle b = new Bundle();
           b.putInt("item_id",id);

           HomeWork28BookDetailFragment f = new HomeWork28BookDetailFragment();
           f.setArguments(b);

           getFragmentManager().beginTransaction().replace(R.id.book_detail_container,f).commit();
       }else{
           Intent i = new Intent(this,HomeWork28ActivityBookDetail.class);
           i.putExtra("item_id",id);
           startActivity(i);
       }
    }
}

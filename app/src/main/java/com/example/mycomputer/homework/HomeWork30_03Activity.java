package com.example.mycomputer.homework;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/6/1.
 */
public class HomeWork30_03Activity extends BaseActivity {
    ImageView iv;
    AnimationDrawable ad;
    MediaPlayer music;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework30_03_layout);
        iv= (ImageView) findViewById(R.id.imageView10);
        ad= (AnimationDrawable) iv.getBackground();

    }
    public void play(View view){
        ad.start();
        if (music==null){
            music=MediaPlayer.create(this, R.raw.bomb);
        }
        music.start();
    }
}

package com.example.mycomputer.homework;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/6/8.
 */
public class VideoViewActivity extends BaseActivity {
    VideoView videoView;
    MediaController mediaController;

    @Override
    protected void initContentView(Bundle savedInstanceState) throws IOException {
        setContentView(R.layout.video_layout);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        videoView = (VideoView) findViewById(R.id.video);
        mediaController = new MediaController(this);
        File video = new File("/mnt/sdcard/1460981662024.mp4");
        if (video.exists()) {
            videoView.setVideoPath(video.getAbsolutePath());
            videoView.setMediaController(mediaController);
            mediaController.setMediaPlayer(videoView);
            videoView.requestFocus();
            videoView.start();
        }
    }
}

package com.example.madm2practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Video_View extends AppCompatActivity {

    VideoView videoView;
    Button back, open;
    int REQUEST_CODE = 456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        videoView = findViewById(R.id.videoView);
        back = findViewById(R.id.back);
        open = findViewById(R.id.open);

        back.setOnClickListener(v -> {
            Intent backIntent = new Intent(Video_View.this, MainActivity.class);
            startActivity(backIntent);
        });

        open.setOnClickListener(v -> {
            Intent openIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            startActivityForResult(openIntent, REQUEST_CODE);
        });

        MediaController mediaController = new MediaController(Video_View.this);
        mediaController.setAnchorView(findViewById(R.id.frame));
        videoView.setMediaController(mediaController);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Uri videoUri = data.getData();
            videoView.setVideoURI(videoUri);
            videoView.start();
        } else {
            Toast.makeText(Video_View.this, "Cancelled", Toast.LENGTH_SHORT).show();
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
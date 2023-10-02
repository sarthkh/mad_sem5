package com.example.mad_exp_6;

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

public class Video extends AppCompatActivity {

    private VideoView videoView;
    private static final int REQUEST_CODE = 456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.videoView);
        Button open = findViewById(R.id.button3);
        Button back = findViewById(R.id.button4);

        open.setOnClickListener(view -> {
            Intent intent3 = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            startActivityForResult(intent3, REQUEST_CODE);
        });

        back.setOnClickListener(view -> {
            Intent intent4 = new Intent(Video.this, MainActivity.class);
            startActivity(intent4);
        });

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(findViewById(R.id.videoFrameLayout));
        videoView.setMediaController(mediaController);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Uri videoUri = data.getData();
            videoView.setVideoURI(videoUri);
            videoView.start();
        } else {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
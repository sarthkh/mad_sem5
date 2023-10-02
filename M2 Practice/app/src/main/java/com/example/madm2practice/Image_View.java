package com.example.madm2practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Image_View extends AppCompatActivity {

    ImageView imageView;
    Button back, open;
    int REQUEST_CODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        imageView = findViewById(R.id.imageView);
        back = findViewById(R.id.back);
        open = findViewById(R.id.open);

        back.setOnClickListener(v -> {
            Intent backIntent = new Intent(Image_View.this, MainActivity.class);
            startActivity(backIntent);
        });

        open.setOnClickListener(v -> {
            Intent openIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(openIntent, REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Bitmap pic = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(pic);
        } else {
            Toast.makeText(Image_View.this, "Cancelled", Toast.LENGTH_SHORT).show();
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

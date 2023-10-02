package com.example.mad_exp_6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Photo extends AppCompatActivity {

    private static final int REQUEST_CODE = 123;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        imageView = findViewById(R.id.imageView2);
        Button open = findViewById(R.id.button3);
        Button back = findViewById(R.id.button4);

        open.setOnClickListener(view -> {
            Intent intent3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent3, REQUEST_CODE);
        });

        back.setOnClickListener(view -> {
            Intent intent4 = new Intent(Photo.this, MainActivity.class);
            startActivity(intent4);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Bitmap pic = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(pic);
        }
        else {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

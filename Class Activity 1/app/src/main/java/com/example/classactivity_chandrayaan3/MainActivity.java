package com.example.classactivity_chandrayaan3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.buttonClickListener {

    private RecyclerView recyclerView;
    private ArrayList<Integer> images;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images = new ArrayList<>();
        images.add(R.drawable.img1);
        images.add(R.drawable.img2);
        images.add(R.drawable.img3);
        images.add(R.drawable.img4);
        images.add(R.drawable.img5);
        images.add(R.drawable.img6);
        images.add(R.drawable.img7);
        images.add(R.drawable.img8);
        images.add(R.drawable.img9);
        images.add(R.drawable.img10);
        images.add(R.drawable.img11);
        images.add(R.drawable.img12);
        images.add(R.drawable.img13);
        images.add(R.drawable.img14);
        images.add(R.drawable.img15);
        images.add(R.drawable.img16);

        recyclerView = findViewById(R.id.recycler_view);

        recyclerViewAdapter = new RecyclerViewAdapter(this, images, this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

//    @Override
//    public void onItemCLick(int position) {
//        int p = position + 1;
//        Toast.makeText(MainActivity.this, "Image - " + p, Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void onButtonCLick(int position) {
//        int p = position + 1;
//        Toast.makeText(MainActivity.this, "Image - " + p, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("i", images.get(position).intValue());
        startActivity(intent);
    }
}
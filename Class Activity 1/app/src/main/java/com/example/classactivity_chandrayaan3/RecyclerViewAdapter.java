package com.example.classactivity_chandrayaan3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private final Context context;
    private final ArrayList<Integer> images;
    buttonClickListener buttonClickListener;

    public RecyclerViewAdapter(Context ctx, ArrayList<Integer> img, buttonClickListener bcl) {
        this.context = ctx;
        this.images = img;
        this.buttonClickListener = bcl;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.activity_single_image_recycler_adapter, parent,false
        );
        return new ViewHolder(view, buttonClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        //to show images using glide library
        Glide.with(context)
                .load(images.get(position))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        buttonClickListener buttonClickListener;
        Button button;
        public ViewHolder(View itemView, buttonClickListener bcl) {
            super(itemView);

            this.buttonClickListener = bcl;
//            itemView.setOnClickListener(this);

            imageView = itemView.findViewById(R.id.imageView);
            button = itemView.findViewById(R.id.button);

            button.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            buttonClickListener.onButtonCLick(getAdapterPosition());
        }
    }

    public interface buttonClickListener {
        void onButtonCLick(int position);
    }
}

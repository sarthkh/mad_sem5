package com.example.exp4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customBaseAdapter extends BaseAdapter {

    Context context;
    String[] listDetails;
    int[] listImages;
    LayoutInflater inflater;

    public customBaseAdapter(Context ctx, String[] details, int[] images) {
        this.context = ctx;
        this.listDetails = details;
        this.listImages = images;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return listDetails.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_main3, null);
        TextView textView = convertView.findViewById(R.id.textView);
        ImageView imageView = convertView.findViewById(R.id.imageIcon);
        textView.setText(listDetails[position]);
        imageView.setImageResource(listImages[position]);
        return convertView;
    }
}

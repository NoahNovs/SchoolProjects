package com.example.selfieaday;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private Context context;
    private ArrayList<PictureImage> picList;

    public ImageAdapter(Context context, ArrayList<PictureImage> picList)
    {
        this.context = context;
        this.picList = picList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imView = itemView.findViewById(R.id.ivView);

            imView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),FullSizeImage.class);
                    intent.putExtra("URL", picList.get(getAdapterPosition()).getImage_url());
                    intent.putExtra("POS", getAdapterPosition());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PictureImage pic = picList.get(position);
        Glide.with(context)
                .load(pic.getImage_url())
                .into(holder.imView);
    }

    @Override
    public int getItemCount() {
        return picList.size();
    }
}

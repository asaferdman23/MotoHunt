package com.motorolasolutions.motohunt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.HomeViewHolder> {

    private final List<QuestionData> mHomeList;
    private HomeViewHolder[] holders;
    private ItemClickListener clickListener;

    public MyAdapter(Context mContext, List<QuestionData> mHomeList) {
        holders = new HomeViewHolder[16];
        this.mHomeList = mHomeList;
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_row, parent, false);
        return new HomeViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final HomeViewHolder holder, int position) {
        holders[position] = holder;
        holder.mImage.setImageResource(mHomeList.get(position).getItemImage());
//        holder.mTitle.setText(mHomeList.get(position).getItemName());
    }

    @Override
    public int getItemCount() {
        return mHomeList.size();
    }

    public void changePicByPos(int res, int position){
        holders[position].changePic(res);
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView mImage;

        HomeViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.imageView);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
            mImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition());
        }

        public void changePic(int res){
            mImage.setImageResource(res);
        }
    }
}



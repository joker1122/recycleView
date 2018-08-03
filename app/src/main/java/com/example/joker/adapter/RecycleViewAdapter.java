package com.example.joker.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joker.data.ItemData;
import com.example.joker.recycleview.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<ItemData> mItemData;

    public RecycleViewAdapter(Context context, ArrayList<ItemData> itemData) {
        super();
        mItemData = itemData;
        mContext = context;
    }

    @NonNull
    @Override
    public MyVeiwHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_layout, viewGroup);
        MyVeiwHolder myVeiwHolder = new MyVeiwHolder(view);
        return myVeiwHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((MyVeiwHolder) viewHolder).mTextView.setText(mItemData.get(i).getDetal());
        ((MyVeiwHolder) viewHolder).mImageView.setImageBitmap(mItemData.get(i).getBitmap());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyVeiwHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView;

        public MyVeiwHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.img_view);
            mTextView = itemView.findViewById(R.id.tv_detail);
            mImageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
        }
    }
}

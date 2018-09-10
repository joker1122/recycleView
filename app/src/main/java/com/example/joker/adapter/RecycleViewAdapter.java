package com.example.joker.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joker.presenter.BasePresenter;
import com.example.joker.recycleview.R;


public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {
    private Context mContext;
    private BasePresenter mPresenter;
    private ItemClickListener mClickListener;
    int number = 0;

    public interface ItemClickListener {
        void onClickListener();

        void onLongClickListener(int position);
    }

    public void setListener(ItemClickListener listener) {
        mClickListener = listener;
    }

    public RecycleViewAdapter(Context context, BasePresenter presenter) {
        super();
        mPresenter = presenter;
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d("get", "onCreateViewHolder" + i);
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_layout, viewGroup, false);
        MyViewHolder myVeiwHolder = new MyViewHolder(view);
        return myVeiwHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d("get", "onBindViewHolder" + position);
        holder.mTextView.setText(mPresenter.getItemData().get(position).getDetal());
        holder.mImageView.setImageBitmap(mPresenter.getItemData().get(position).getBitmap());
        holder.mImageView.setTag(position);
        holder.mImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mClickListener.onLongClickListener((int) v.getTag());
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPresenter.getItemData().size();
    }

    public void flush() {
        notifyDataSetChanged();
    }

    public void addItem() {
//        notifyDataSetChanged();
        notifyItemInserted(0);
        notifyItemRangeChanged(0, mPresenter.getItemData().size());
    }

    public void addItem(int position) {
//        notifyDataSetChanged();
        notifyItemInserted(position);
        notifyItemRangeChanged(position, mPresenter.getItemData().size());
    }

    public void deleteItem() {
//        notifyDataSetChanged();
        notifyItemRemoved(0);
        notifyItemRangeChanged(0, mPresenter.getItemData().size());
    }

    public void deleteItem(int position) {
//        notifyDataSetChanged();
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mPresenter.getItemData().size());
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.img_view);
            mTextView = itemView.findViewById(R.id.tv_detail);
        }
    }
}

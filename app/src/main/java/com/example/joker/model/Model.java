package com.example.joker.model;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.joker.data.ItemData;
import com.example.joker.recycleview.R;
import com.example.joker.util.CallBack;

import java.util.ArrayList;
import java.util.List;

public class Model implements BaseModel {
    private Thread mThread = null;
    private Context mContext;
    private ArrayList<ItemData> mItemData = new ArrayList<>();
    private List<Bitmap> mBitmaps;

    public Model(Context context) {
        mBitmaps = new ArrayList<>();
        mContext = context;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.pic_one, options);
        Bitmap bitmap1 = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.pic_two, options);
        mBitmaps.add(bitmap);
        mBitmaps.add(bitmap1);
    }

    @Override
    public void doInBackground(final CallBack callBack) {
        if (null == mThread) {
            mThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < 20; i++) {
                            ItemData itemData = new ItemData(mBitmaps.get((int) Math.floor(Math.random() * 1.9)), "the number is " + i);
                            mItemData.add(itemData);
                        }
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    callBack.callback();
                    mThread = null;
                }
            });
            mThread.start();
        } else {
            System.out.print("too fast");
        }
    }

    @Override
    public void addItem() {
        mItemData.add(0, new ItemData(mBitmaps.get((int) Math.floor(Math.random() * 1.9)), "example"));
    }

    @Override
    public void addItem(int position) {
        mItemData.add(position, new ItemData(mBitmaps.get((int) Math.floor(Math.random() * 1.9)), "addItem"));
    }

    @Override
    public void deleteItem(int position) {
        if (mItemData.size() == 0) {
            return;
        }
        mItemData.remove(position);
    }

    @Override
    public void deleteItem() {
        if (mItemData.size() == 0) {
            return;
        }
        mItemData.remove(0);
    }

    @Override
    public void flushItem() {

    }

    @Override
    public ArrayList<ItemData> getItemDate() {
        return mItemData;
    }
}

package com.example.joker.model;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.joker.data.ItemData;
import com.example.joker.recycleview.R;
import com.example.joker.util.CallBack;

import java.util.ArrayList;

public class Model implements BaseModel {
    private Thread mThread = null;
    private Context mContext;
    private ArrayList<ItemData> mItemData = new ArrayList<>();

    @Override
    public void doInBackground(final Context context, final CallBack callBack) {
        mContext = context;
        if (null == mThread) {
            mThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < 100; i++) {
                            if (Math.random() * 2 > 1) {
                                Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_launcher_round);
                                ItemData itemData = new ItemData(bitmap, "the number is " + i);
                                mItemData.add(itemData);
                            } else {
                                Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_launcher);
                                ItemData itemData = new ItemData(bitmap, "the number is " + i);
                                mItemData.add(itemData);
                            }
                        }
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    callBack.callback(mItemData);
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

    }

    @Override
    public void deleteItem() {

    }

    @Override
    public void flushItem() {

    }
}

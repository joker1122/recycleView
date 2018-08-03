package com.example.joker.data;

import android.graphics.Bitmap;

public class ItemData {
    private Bitmap mBitmap;
    private String mDetal;

    public ItemData(Bitmap bitmap, String detal) {
        mBitmap = bitmap;
        mDetal = detal;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        mBitmap = bitmap;
    }

    public String getDetal() {
        return mDetal;
    }

    public void setDetal(String detal) {
        mDetal = detal;
    }
}

package com.example.joker.model;

import android.content.Context;

import com.example.joker.util.CallBack;

public interface BaseModel {
    void doInBackground(Context context, CallBack callBack);

    void addItem();

    void deleteItem();

    void flushItem();
}

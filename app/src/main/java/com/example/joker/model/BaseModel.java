package com.example.joker.model;

import android.content.Context;

import com.example.joker.data.ItemData;
import com.example.joker.util.CallBack;

import java.util.ArrayList;

public interface BaseModel {
    void doInBackground(CallBack callBack);

    void addItem();

    void addItem(int position);

    void deleteItem();

    void deleteItem(int position);

    void flushItem();

    ArrayList<ItemData> getItemDate();
}

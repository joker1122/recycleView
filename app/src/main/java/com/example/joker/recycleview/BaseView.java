package com.example.joker.recycleview;

import com.example.joker.data.ItemData;

import java.util.ArrayList;

public interface BaseView {
    void addItem();

    void deleteItem();


    void addItem(int position);

    void deleteItem(int position);

    void reflush();
}

package com.example.joker.recycleview;

import com.example.joker.data.ItemData;

import java.util.ArrayList;

public interface BaseView {
    void addItem();

    void deleteItem();

    void reflush(ArrayList<ItemData> itemData);
}

package com.example.joker.presenter;


import com.example.joker.data.ItemData;
import com.example.joker.recycleview.BaseView;

import java.util.ArrayList;

public interface BasePresenter {
    void attachView(BaseView view);

    BaseView getView();

    void addItem();

    void addItem(int position);

    void deleteItem();

    void deleteItem(int position);

    void flushItem();

    ArrayList<ItemData> getItemData();
}

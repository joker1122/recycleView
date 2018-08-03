package com.example.joker.presenter;


import android.content.Context;

import com.example.joker.data.ItemData;
import com.example.joker.model.BaseModel;
import com.example.joker.model.Model;
import com.example.joker.recycleview.BaseView;
import com.example.joker.util.CallBack;

import java.util.ArrayList;

public class Presenter implements BasePresenter, CallBack {
    private BaseView mView;
    private BaseModel mBaseModel;

    public Presenter() {
        mBaseModel = new Model();
    }

    @Override
    public void attachView(BaseView view) {
        mView = view;
    }

    @Override
    public BaseView getView() {
        return mView;
    }

    public void addItem() {

    }

    public void deleteItem() {

    }

    public void flushItem(Context context) {
        mBaseModel.doInBackground(context, this);
    }

    @Override
    public void callback(ArrayList<ItemData> itemData) {
        mView.reflush(itemData);
    }
}

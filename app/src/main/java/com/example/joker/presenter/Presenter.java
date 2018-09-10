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

    public Presenter(Context context) {
        mBaseModel = new Model(context);
    }

    @Override
    public void attachView(BaseView view) {
        mView = view;
    }

    @Override
    public BaseView getView() {
        return mView;
    }

    @Override
    public void addItem() {
        mBaseModel.addItem();
        mView.addItem();
    }

    @Override
    public void addItem(int position) {
        mBaseModel.addItem(position);
        mView.addItem(position);
    }

    @Override
    public void deleteItem() {
        mBaseModel.deleteItem();
        mView.deleteItem();
    }

    @Override
    public void deleteItem(int position) {
        mBaseModel.deleteItem(position);
        mView.deleteItem(position);
    }

    @Override
    public void flushItem() {
        mBaseModel.doInBackground(this);
    }

    @Override
    public void callback() {
        mView.reflush();
    }

    @Override
    public ArrayList<ItemData> getItemData() {
        return mBaseModel.getItemDate();
    }
}

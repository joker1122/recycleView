package com.example.joker.presenter;


import com.example.joker.model.BaseModel;
import com.example.joker.recycleview.BaseView;

public interface BasePresenter<M extends BaseModel, V extends BaseView> {
    void attachView(V view);

    BaseView getView();
}

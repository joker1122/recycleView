package com.example.joker.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.joker.adapter.RecycleViewAdapter;
import com.example.joker.data.ItemData;
import com.example.joker.presenter.Presenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BaseView {
    private Presenter mPresenter;
    private RecycleViewAdapter mRecycleViewAdapter;
    private Button mButtonAdd;
    private Button mButtonDel;
    private Button mButtonFlush;
    private RecyclerView mRecyclerView;
    private ArrayList<ItemData> mItemData;

    private void init() {
        mPresenter = new Presenter();
        mPresenter.attachView(this);
        mButtonAdd = findViewById(R.id.bt_add);
        mButtonDel = findViewById(R.id.bt_del);
        mButtonFlush = findViewById(R.id.bt_flush);
        mRecyclerView = findViewById(R.id.recycle_view);
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.addItem();
            }
        });
        mButtonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.deleteItem();
            }
        });
        mButtonFlush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.flushItem(getApplicationContext());
                mRecycleViewAdapter.notifyDataSetChanged();
            }
        });
        mPresenter.flushItem(getApplicationContext());
        if (null == mItemData) {
            mItemData = new ArrayList<>();
        }
        mRecycleViewAdapter = new RecycleViewAdapter(this, mItemData);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        mRecyclerView.setAdapter(mRecycleViewAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public void addItem() {
    }

    @Override
    public void deleteItem() {
    }

    @Override
    public void reflush(ArrayList<ItemData> itemData) {
        mItemData = itemData;
    }
}

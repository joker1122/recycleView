package com.example.joker.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.joker.adapter.RecycleViewAdapter;
import com.example.joker.presenter.BasePresenter;
import com.example.joker.presenter.Presenter;


public class MainActivity extends AppCompatActivity implements BaseView {
    private BasePresenter mPresenter;
    private RecycleViewAdapter mRecycleViewAdapter;
    private Button mButtonAdd;
    private Button mButtonDel;
    private Button mButtonFlush;
    private RecyclerView mRecyclerView;

    private void init() {
        mPresenter = new Presenter(this);
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
                mPresenter.flushItem();
            }
        });
        mRecyclerView.setHasFixedSize(true);
        mRecycleViewAdapter = new RecycleViewAdapter(this, mPresenter);
        mRecycleViewAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                Log.d("joker","onChanged");
                super.onChanged();
            }

            @Override
            public void onItemRangeChanged(int positionStart, int itemCount) {
                Log.d("joker","onItemRangeChanged");
                super.onItemRangeChanged(positionStart, itemCount);
            }

            @Override
            public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
                Log.d("joker","onItemRangeChanged2");
                super.onItemRangeChanged(positionStart, itemCount, payload);
            }

            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                Log.d("joker","onItemRangeInserted");
                super.onItemRangeInserted(positionStart, itemCount);
            }

            @Override
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                Log.d("joker","onItemRangeRemoved");
                super.onItemRangeRemoved(positionStart, itemCount);
            }

            @Override
            public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                super.onItemRangeMoved(fromPosition, toPosition, itemCount);
            }
        });
        mRecycleViewAdapter.setListener(new RecycleViewAdapter.ItemClickListener() {
            @Override
            public void onClickListener() {

            }

            @Override
            public void onLongClickListener(int position) {
                mPresenter.deleteItem(position);
            }
        });
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
        mRecycleViewAdapter.addItem();
    }

    @Override
    public void addItem(int position) {
        mRecycleViewAdapter.addItem(position);
    }

    @Override
    public void deleteItem(int position) {
        mRecycleViewAdapter.deleteItem(position);
    }

    @Override
    public void deleteItem() {
        mRecycleViewAdapter.deleteItem();
    }

    @Override
    public void reflush() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mRecycleViewAdapter.flush();
            }
        });
    }
}

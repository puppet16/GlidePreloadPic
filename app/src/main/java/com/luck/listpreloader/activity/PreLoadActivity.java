package com.luck.listpreloader.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.luck.listpreloader.adapter.PreLoadAdapter;
import com.luck.listpreloader.R;
import com.luck.listpreloader.widget.GlidePicPreLoadManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*************************************************************************************
 * Module Name:
 * Description:
 * Author: 李桐桐
 * Date:   2019/4/24
 *************************************************************************************/
public class PreLoadActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private RecyclerView mRvPreLoad;
    private PreLoadAdapter mAdapter;
    private List<String> mData = new ArrayList<>();
    private GlidePicPreLoadManager mPreLoadManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preload);
        mAdapter = new PreLoadAdapter(this);
        mRvPreLoad = findViewById(R.id.rv_preload);
        mPreLoadManager = new GlidePicPreLoadManager();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL);
        mRvPreLoad.addItemDecoration(itemDecoration);
        mRvPreLoad.setLayoutManager(layoutManager);
        mRvPreLoad.setAdapter(mAdapter);
        initData();
    }

    private void initData() {
        mData = Arrays.asList(getResources().getStringArray(R.array.url_list));
        mAdapter.setDatas(mData);
        mPreLoadManager.preLoadCover(mData);
    }
}

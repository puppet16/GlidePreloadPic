package com.luck.listpreloader.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.luck.listpreloader.R;
import com.luck.listpreloader.utils.GlideCacheUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = findViewById(R.id.tv_size);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTv.setText(getString(R.string.cache_size, GlideCacheUtil.getInstance().getCacheSize(this)));
    }

    @OnClick({R.id.btn_next, R.id.btn_listpreload, R.id.btn_preload, R.id.btn_clear})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
                break;
            case R.id.btn_listpreload:
                startActivity(new Intent(MainActivity.this, ListPreLoadActivity.class));
                break;
            case R.id.btn_preload:
                startActivity(new Intent(MainActivity.this, PreLoadActivity.class));
                break;
            case R.id.btn_clear:
                GlideCacheUtil.getInstance().clearImageAllCache(this);
                mTv.setText(getString(R.string.cache_size, GlideCacheUtil.getInstance().getCacheSize(this)));

                break;
        }
    }

}

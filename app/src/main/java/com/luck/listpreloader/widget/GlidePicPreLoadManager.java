package com.luck.listpreloader.widget;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.luck.listpreloader.R;
import com.luck.listpreloader.TheApplication;

import java.util.List;

/*************************************************************************************
 * Module Name:
 * Description:
 * Author: 李桐桐
 * Date:   2019/4/23
 *************************************************************************************/
public class GlidePicPreLoadManager {

    private Context mContext = TheApplication.getInstance();

    public GlidePicPreLoadManager() {

    }

    public void preLoadCover(List<String> beans) {
        if (beans == null) return;

        RequestOptions requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        for (String bean : beans) {
            Glide.with(mContext)
                    .load(bean)
                    .apply(requestOptions)
                    .preload();
        }

    }
}

package com.luck.listpreloader;


import android.app.Application;

/*************************************************************************************
 * Module Name:
 * Description:
 * Author: 李桐桐
 * Date:   2019/4/24
 *************************************************************************************/
public class TheApplication extends Application {
    private static TheApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static TheApplication getInstance() {
        return mInstance;
    }
}

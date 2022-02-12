package com.gmail.wjdrhkddud2.globalhandler;

import android.app.Application;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Thread.UncaughtExceptionHandler defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler(defaultExceptionHandler, this, getApplicationContext()));

    }
}

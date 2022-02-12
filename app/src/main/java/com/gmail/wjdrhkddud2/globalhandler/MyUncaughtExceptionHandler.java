package com.gmail.wjdrhkddud2.globalhandler;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.PrintWriter;
import java.io.StringWriter;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private Context applicationContext;
    private Activity lastActivity;
    private int activityCount = 0;

    public MyUncaughtExceptionHandler(Thread.UncaughtExceptionHandler defaultHandler, Application application, Context context) {

        this.applicationContext = context;
        mDefaultHandler = defaultHandler;
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {

                System.out.println("Create");
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

                System.out.println("Start");
                lastActivity = activity;
                activityCount++;
            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

                System.out.println("Resume");

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

                System.out.println("Pause");
            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

                System.out.println("Stopped");
                activityCount--;

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

                System.out.println("SaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {

                System.out.println("Destroyed");
            }
        });

    }

    @Override
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable throwable) {

        //mDefaultHandler.uncaughtException(thread, throwable);

        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));

        Intent intent = new Intent(applicationContext, ExceptionActivity.class);
        Intent lastIntent = new Intent(applicationContext, lastActivity.getClass());
        intent.putExtra("EXCEPTION.INTENT", lastIntent);
        intent.putExtra("EXCEPTION", stringWriter.toString());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        applicationContext.startActivity(intent);

        Process.killProcess(Process.myPid());
        System.exit(-1);



    }
}

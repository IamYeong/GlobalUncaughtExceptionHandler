package com.gmail.wjdrhkddud2.globalhandler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button crashButton, subButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(@NonNull Thread thread, @NonNull Throwable throwable) {
                System.out.println("Uncaught Exception");

                //finish();

                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);

                Process.killProcess(Process.myPid());
                System.exit(-1);
            }
        });

         */

        subButton = findViewById(R.id.btn_to_sub);
        crashButton = findViewById(R.id.btn_main_crash);

        crashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                throw new RuntimeException("MyException");

            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);

            }
        });


    }


}
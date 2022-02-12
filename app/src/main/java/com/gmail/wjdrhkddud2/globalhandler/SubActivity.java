package com.gmail.wjdrhkddud2.globalhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    private Button crashButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        System.out.println("Sub activity onCreate");

        crashButton = findViewById(R.id.btn_sub_crash);
        crashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                throw new RuntimeException("A");

            }
        });
    }
}
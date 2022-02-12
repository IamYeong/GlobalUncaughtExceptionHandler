package com.gmail.wjdrhkddud2.globalhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExceptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exception);

        Intent intent = getIntent();

        String message = intent.getStringExtra("EXCEPTION");
        Intent lastActivityIntent = intent.getParcelableExtra("EXCEPTION.INTENT");

        TextView errorText = findViewById(R.id.tv_error);

        System.out.println(message);

        Button button = findViewById(R.id.btn_previous);

        errorText.setText(message);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(lastActivityIntent);
                finish();

            }
        });

    }
}
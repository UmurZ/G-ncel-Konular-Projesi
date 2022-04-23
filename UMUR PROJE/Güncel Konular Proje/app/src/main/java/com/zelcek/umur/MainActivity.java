package com.zelcek.umur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.start_quiz).setOnClickListener(v -> {
            Intent intent = new Intent(this, QuizActivity.class);
            startActivity(intent);
        });
    }
}
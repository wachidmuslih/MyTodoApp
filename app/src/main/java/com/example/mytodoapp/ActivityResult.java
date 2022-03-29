package com.example.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityResult extends AppCompatActivity {
    TextView tvTask, tvJenis, tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvTask = findViewById(R.id.txhasilTask);
        tvJenis = findViewById(R.id.tvhasilJenis);
        tvTime = findViewById(R.id.tvHasilTime);

        Bundle bundle = getIntent().getExtras();

        String task = bundle.getString("a");
        String jenis = bundle.getString("b");
        String time = bundle.getString("c");

        tvTask.setText(task);
        tvTime.setText(time);
        tvJenis.setText(jenis);
    }
}
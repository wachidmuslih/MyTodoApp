package com.example.mytodoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityTodo extends AppCompatActivity {
    EditText edTask, edJenis, edTime;
    FloatingActionButton fab;
    String task, jenisTask, time;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== R.id.submit){
            edTask = findViewById(R.id.edtTask);
            edJenis = findViewById(R.id.edtJenis);
            edTime  = findViewById(R.id.edtTime);

            if(edTask.getText().toString().isEmpty() || edJenis.getText().toString().isEmpty() || edTime.getText().toString().isEmpty()){
                Toast toast = Toast.makeText(getApplicationContext(), "WAJIB DIISI!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0,0);
                toast.show();
            }
            else {
                task = edTask.getText().toString();
                jenisTask = edJenis.getText().toString();
                time = edTime.getText().toString();

                Bundle b = new Bundle();

                b.putString("a", task.trim());

                b.putString("b", jenisTask.trim());

                b.putString("c", time.trim());

                Intent intent = new Intent(getApplicationContext(), ActivityResult.class);

                intent.putExtras(b);

                startActivity(intent);
            }
        }
        if(item.getItemId()==R.id.logout){
            Intent intent = new Intent(ActivityTodo.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
    }
}
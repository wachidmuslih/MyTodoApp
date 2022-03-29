package com.example.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //inisialisasi
    Button btnLogin, btnRegister;
    EditText edName, edpassw;
    String nama, password, email, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menghubungkan variabel dengan component di layout
        btnLogin = findViewById(R.id.btnSignin);

        btnRegister = findViewById(R.id.btnRegist);

        edName = findViewById(R.id.edNama);

        edpassw = findViewById(R.id.edPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validation();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivityRegister.class));
            }
        });
    }

    private void validation() {
        //menyimpan input di edittext ke dalam variabel
        nama = edName.getText().toString();

        password = edpassw.getText().toString();

        // isi variabel email dan pwd
        email = "Pascal";

        pwd = "iniPascal";

        if( nama.isEmpty() && password.isEmpty())
        {
            edName.setError("Email diperlukan!");
            edpassw.setError("Password diperlukan!");
        }
        if ( nama.equals(email) && password.equals(pwd))
        {
            Toast toast = Toast.makeText(getApplicationContext(), "LOGIN SUKSES", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0,0);
            toast.show();



            Intent i = new Intent(getApplicationContext(), ActivityTodo.class);

            startActivity(i);
        }
        else if ( !nama.equals(email) && password.equals(pwd))
        {
            Toast toast = Toast.makeText(getApplicationContext(), "EMAIL SALAH", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0,0);
            toast.show();
        }
        else if ( nama.equals(email) && !password.equals(pwd))
        {
            Toast toast = Toast.makeText(getApplicationContext(), "PASSWORD SALAH", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0,0);
            toast.show();
        }
        else if ( !nama.equals(email) && !password.equals(pwd))
        {
            Toast toast = Toast.makeText(getApplicationContext(), "EMAIL DAN PASSWORD SALAH", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0,0);
            toast.show();
        }
    }
}
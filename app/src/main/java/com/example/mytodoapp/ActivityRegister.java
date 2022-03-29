package com.example.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegister extends AppCompatActivity {

    //inisialisasi
    Button btnRegistrasi;
    EditText ednm, edemail, edpass, edrepass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ednm = findViewById(R.id.edNama);

        edemail = findViewById(R.id.edemail2);

        edpass  = findViewById(R.id.edpass);

        edrepass = findViewById(R.id.edrepass);

        btnRegistrasi = findViewById(R.id.btnRegister);

        btnRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ednm.getText().toString().isEmpty() || edemail.getText().toString().isEmpty()
                || edpass.getText().toString().isEmpty() || edrepass.getText().toString().isEmpty())
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "DATA WAJIB DIISI!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0,0);
                    toast.show();
                }
                else {
                    if (edpass.getText().toString().equals(edrepass.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil...", Toast.LENGTH_LONG).show();

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Password dan Repassword harus sama!...", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
}
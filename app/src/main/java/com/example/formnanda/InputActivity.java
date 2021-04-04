package com.example.formnanda;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;


public class InputActivity extends AppCompatActivity {

    Button tblSubmit;
    EditText isiNama, isiPassword, isiNilai;
    String tvConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        isiNama = findViewById(R.id.isiNama);
        isiPassword = findViewById(R.id.isiPassword);
        isiNilai = findViewById(R.id.isiNilai);
        tblSubmit = findViewById(R.id.tblSubmit);

        tblSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sNama = isiNama.getText().toString();
                String sPassword = isiPassword.getText().toString();
                String sNilai = isiNilai.getText().toString();
                if (TextUtils.isEmpty(sNama)) {
                    isiNama.setError("Nama Tidak Boleh Kosong");
                } else if (TextUtils.isEmpty(sPassword)) {
                    isiPassword.setError("Password Tidak Boleh Kosong");
                } else if (TextUtils.isEmpty(sNilai)) {
                    isiNilai.setError("Nilai Tidak Boleh Kosong");
                } else {
                    try {
                        double Nilai = Double.parseDouble(sNilai);

                        if (Nilai == 1.00) {
                            tvConvert = "D";
                        } else if (Nilai > 1.00 && Nilai <= 1.33) {
                            tvConvert = "D+";
                        } else if (Nilai > 1.33 && Nilai <= 1.66) {
                            tvConvert = "C-";
                        } else if (Nilai > 1.66 && Nilai <= 2.00) {
                            tvConvert = "C";
                        } else if (Nilai > 2.00 && Nilai <= 2.33) {
                            tvConvert = "C+";
                        } else if (Nilai > 2.33 && Nilai <= 2.66) {
                            tvConvert = "B-";
                        } else if (Nilai > 2.66 && Nilai <= 3.00) {
                            tvConvert = "B";
                        } else if (Nilai > 3.00 && Nilai <= 3.33) {
                            tvConvert = "B+";
                        } else if (Nilai > 3.33 && Nilai <= 3.66) {
                            tvConvert = "A-";
                        } else if (Nilai > 3.66 && Nilai <= 4.00) {
                            tvConvert = "A";
                        } else
                            Toast.makeText(getApplicationContext(), "Angka yang Anda masukkan salah!!!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(InputActivity.this, MainActivity.class);
                        i.putExtra("nama", sNama);
                        i.putExtra("password", sPassword);
                        i.putExtra("convert", tvConvert);
                        startActivity(i);
                    } catch (NumberFormatException nfe) {
                        Toast.makeText(getApplicationContext(), "Nilai yang anda inputkan salah!!!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Data yang anda inputkan salah!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
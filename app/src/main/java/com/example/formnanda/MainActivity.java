package com.example.formnanda;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView Namacity;
    TextView Passwordcity;
    TextView Hasilcity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String Nama = getIntent().getExtras().getString("nama");
        String Pass = getIntent().getExtras().getString("password");
        String Hasil = getIntent().getExtras().getString("convert");

        Namacity = findViewById(R.id.Namacity);
        Passwordcity = findViewById(R.id.Passwordcity);
        Hasilcity = findViewById(R.id.Nilaicity);

        Namacity.setText("Nama            : " + Nama);
        Passwordcity.setText("Password    : " + Pass);
        Hasilcity.setText("Nilai              : " + Hasil);
    }
}
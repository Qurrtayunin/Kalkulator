package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {
    String operasi = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.penjumlahan:
                operasi = "+";
                break;
            case R.id.pengurangan:
                operasi = "-";
                break;
            case R.id.perkalian:
                operasi = "x";
                break;
            case R.id.pembagian:
                operasi = "/";
                break;
        }
        returnIntent();
    }

    public void returnIntent() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("operasi", operasi);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}

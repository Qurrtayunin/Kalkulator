package com.example.kalkulator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit_bilangan1,edit_bilangan2;
    TextView result;
    Button operasi, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_bilangan1=findViewById(R.id.bilangan1);
        edit_bilangan2=findViewById(R.id.bilangan2);
        operasi=findViewById(R.id.pilih_operasi);
        result=findViewById(R.id.result);
        reset=findViewById(R.id.reset);
    }

    public void pilihOperasi(View view) {
        Intent intent = new Intent (this, SecondActivity.class);    //membuka halaman kedua (pilih oprasi yang mana)
        startActivityForResult(intent, 1); //karena kita mau mengambil resultnya
    }

    public void reset(View view) {  //ubah menjadi string kosong
        edit_bilangan1.setText("");
        edit_bilangan2.setText("");
        result.setText("");
    }

    private Double kalkulasi(Double edit_bilangan1, Double edit_bilangan2, String operasi) {
        Double hasil = null;
        switch (operasi) {
            case "+":
                hasil = edit_bilangan1 + edit_bilangan2;
                break;
            case "-":
                hasil = edit_bilangan1 - edit_bilangan2;
                break;
            case "/":
                hasil = edit_bilangan1 / edit_bilangan2;
                break;
            case "x":
                hasil = edit_bilangan1 * edit_bilangan2;
                break;
        }

        return hasil;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {

                Double bil1Value = Double.valueOf(edit_bilangan1.getText().toString());
                Double bil2Value = Double.valueOf(edit_bilangan2.getText().toString());
                String operasi = data.getStringExtra("operasi");
                Double hasil = kalkulasi(bil1Value, bil2Value, operasi);

                String res = bil1Value + " " + operasi + " " + bil2Value + " = " + hasil;
                result.setText(res);
            }
        }

    }
}

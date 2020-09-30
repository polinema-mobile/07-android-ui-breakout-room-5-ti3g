package com.example.jobsheet7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.jobsheet7.models.mahasiswa;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePickerDialog picker;
    EditText nama;
    EditText nim;
    EditText tanggal;
    RadioButton radioButton;
    Spinner jurusan;
    Button submit;
    RadioGroup sex;
    mahasiswa mhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanggal = (EditText)findViewById(R.id.edtTanggalLahir);
        submit = (Button)findViewById(R.id.saveButton);

        tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                tanggal.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });
    }

    public void checkButton(){
        int radioId = sex.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
    }

    public void openSecondActivity(){
        nama = (EditText)findViewById(R.id.edtName);
        nim = (EditText)findViewById(R.id.edtNim);
        tanggal = (EditText)findViewById(R.id.edtTanggalLahir);
        jurusan = (Spinner)findViewById(R.id.spinnerJurusan);
        sex = (RadioGroup)findViewById((R.id.sex));

        String name = nama.getText().toString();
        String no = nim.getText().toString();
        String date = tanggal.getText().toString();
        checkButton();
        String sex = radioButton.getText().toString();
        String major = jurusan.getSelectedItem().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("NIM", no);
        intent.putExtra("tanggal", date);
        intent.putExtra("gender", sex);
        intent.putExtra("jurusan", major);
        //create object mahasiswa
        mhs = new mahasiswa(name,no,date,sex,major);
        // put mahasiswa object to extra
        intent.putExtra("MHSOBJ",mhs);

        startActivity(intent);
    }
}
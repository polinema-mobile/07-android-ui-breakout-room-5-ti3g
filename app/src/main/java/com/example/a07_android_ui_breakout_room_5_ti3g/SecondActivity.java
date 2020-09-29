package com.example.a07_android_ui_breakout_room_5_ti3g;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {
    String name,no,date,sex,jurusan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();

        String name = intent.getStringExtra("name");
        String no = intent.getStringExtra("nim");
        String date = intent.getStringExtra("date");
        String sex = intent.getStringExtra("sex");
        String jurusan = intent.getStringExtra("depart");

//        TextView nama= (TextView)findViewById(R.id.name);
//        TextView nim = (TextView)findViewById(R.id.nim);
//        TextView dob = (TextView)findViewById(R.id.dob);
//        TextView gender = (TextView)findViewById(R.id.sex);
//        TextView depart = (TextView)findViewById(R.id.depart);

        TextView ResultFinal = findViewById(R.id.ResultForm);
        ResultFinal.setText("Name: "+name+"\nNim: "+ no+"\nDateOfBirth: "+date+
                "\nGender: "+ sex+"\nDepartement: "+jurusan);

//        nama.setText(name);
//        nim.setText(no);
//        dob.setText(date);
//        gender.setText(sex);
//        depart.setText(jurusan);

    }
}
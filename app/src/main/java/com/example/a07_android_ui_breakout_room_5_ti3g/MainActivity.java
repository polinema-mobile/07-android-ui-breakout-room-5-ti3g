package com.example.a07_android_ui_breakout_room_5_ti3g;


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

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;



public class MainActivity extends AppCompatActivity {
    private EditText name, nim,date;
    private RadioButton radiobtn;
    private Button save;
    private DatePickerDialog  picker;
    private RadioGroup sex;
    private Spinner depart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = (EditText)findViewById(R.id.dob);
        save = (Button) findViewById(R.id.savebtn);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                picker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            date.setText(dayOfMonth +"/"+month+ "/"+ year);
                    };
                },year,month,day);
                picker.show();
            }
        });
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    name = (EditText)findViewById(R.id.nametxt);
                    nim = (EditText)findViewById(R.id.nimtxt);
                    date =(EditText)findViewById(R.id.dob);
                    depart = (Spinner) findViewById(R.id.depart);
                    sex = (RadioGroup)findViewById((R.id.radioGroup));

                    String nama = name.getText().toString();
                    String no = nim.getText().toString();
                    String dob = date.getText().toString();
                    checkButton();
                    String sex  = radiobtn.getText().toString();
                    String jurusan = depart.getSelectedItem().toString();

                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("name",nama);
                    intent.putExtra("nim",no);
                    intent.putExtra("date",dob);
                    intent.putExtra("sex",sex);
                    intent.putExtra("depart",jurusan);
                    startActivity(intent);
                }
            });
    }
    public void checkButton(){
        int radioId= sex.getCheckedRadioButtonId();
        radiobtn = findViewById(radioId);
    }
}
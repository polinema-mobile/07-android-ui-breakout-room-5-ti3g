package com.example.jobsheet8;

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
//import com.example.jobsheet7.models.mahasiswa;

import java.util.Calendar;

public class ThirdActivity extends AppCompatActivity {
//main activity
    DatePickerDialog picker;
    EditText nama; EditText nik; EditText tanggal; EditText password; EditText confirmPassword;
    EditText alasan; EditText prestasi; EditText RT; EditText RW; EditText KodePos;
    EditText NoTelp; EditText HP; EditText email; EditText alamat;
    RadioButton radioButton; RadioButton radioButton2;
    Spinner jurusan; Spinner agama; Spinner Provinsi;
    Spinner Kota; Spinner fakultas; Spinner status; Spinner prodi;
    Button submit;
    RadioGroup sex; RadioGroup kewarganegaraan;

//    thir activity
    EditText nameUniv; EditText fakultasAsal; EditText programStudi;
    EditText alamatUniv; EditText kodeUniv; EditText akre;
    EditText IPK;
    Spinner ProvUniv; Spinner kotaUniv;
//    mahasiswa mhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        submit = (Button)findViewById(R.id.saveButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFourthActivity();
            }
        });
    }

    public void checkButton(){
//        main activity
        int radioId = sex.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        int radioId2 = kewarganegaraan.getCheckedRadioButtonId();
        radioButton2 = findViewById(radioId2);
    }

    public void openFourthActivity(){
//        mainactivity
        nama = (EditText)findViewById(R.id.edtName);
        nik = (EditText)findViewById(R.id.edtNIK);
        tanggal = (EditText)findViewById(R.id.edtTanggalLahir);
        password = (EditText)findViewById(R.id.editTextTextPassword);
        confirmPassword = (EditText)findViewById(R.id.editTextTextPassword2);
        alasan = (EditText)findViewById(R.id.edtAlasan);
        prestasi = (EditText)findViewById(R.id.edtPrestasi);
        alamat = (EditText)findViewById(R.id.edtAlamat);
        RT = (EditText) findViewById(R.id.edtRT);
        RW = (EditText)findViewById(R.id.edtRW);
        KodePos = (EditText)findViewById(R.id.edtKodePos);
        NoTelp = (EditText)findViewById(R.id.edtNomorRumah);
        HP = (EditText)findViewById(R.id.edtNomorHP);
        email = (EditText)findViewById(R.id.editTextTextEmailAddress);
        jurusan = (Spinner)findViewById(R.id.spinnerJurusan);
        agama = (Spinner)findViewById(R.id.spinnerAgama);
        Provinsi = (Spinner)findViewById(R.id.spinnerProvinsi);
        Kota = (Spinner)findViewById(R.id.spinnerKota);
        fakultas = (Spinner)findViewById(R.id.spinnerJurusan);
        status = (Spinner)findViewById(R.id.spinnerStatus);
        prodi = (Spinner)findViewById(R.id.spinnerProdi);
        sex = (RadioGroup)findViewById((R.id.sex));
        kewarganegaraan = (RadioGroup)findViewById(R.id.Kewarganegaraan);

        String name = nama.getText().toString();
        String no = nik.getText().toString();
        String date = tanggal.getText().toString();
        String pass = password.getText().toString();
        String reason = alasan.getText().toString();
        String reward = prestasi.getText().toString();
        String kode1 = RT.getText().toString();
        String kode2 = RW.getText().toString();
        String passCode = KodePos.getText().toString();
        String phoneNumber = NoTelp.getText().toString();
        String phone = HP.getText().toString();
        String mail = email.getText().toString();
        String street = alamat.getText().toString();
        checkButton();
        String sex = radioButton.getText().toString();
        String kewarganegaraan = radioButton2.getText().toString();
        String major = jurusan.getSelectedItem().toString();
        String pro = prodi.getSelectedItem().toString();
        String agm = agama.getSelectedItem().toString();
        String prov = Provinsi.getSelectedItem().toString();
        String kota = Kota.getSelectedItem().toString();
        String stts = status.getSelectedItem().toString();

        Intent intent = new Intent(this, FourthActivity.class);
        intent.putExtra("Name", name);
        intent.putExtra("Jurusan", major);
        intent.putExtra("Password", pass);
        intent.putExtra("Alasan", reason);
        intent.putExtra("NIK", no);
        intent.putExtra("Presatsi", reward);
        intent.putExtra("Tanggal Lahir", date);
        intent.putExtra("Gender", sex);
        intent.putExtra("Kewarganegaraan", kewarganegaraan);
        intent.putExtra("Agama", agm);
        intent.putExtra("Alamat", street);
        intent.putExtra("RT", kode1);
        intent.putExtra("RW", kode2);
        intent.putExtra("Passcode", passCode);
        intent.putExtra("Provinsi", prov);
        intent.putExtra("Kota", kota);
        intent.putExtra("Nomor Rumah", phoneNumber);
        intent.putExtra("No. HP", phone);
        intent.putExtra("Email", mail);
//        //create object mahasiswa
//        mhs = new mahasiswa(name,no,date,sex,major);
//        // put mahasiswa object to extra
//        intent.putExtra("MHSOBJ",mhs);

//        thirdactivity
        nameUniv = (EditText)findViewById(R.id.edtNameUniv);
        fakultasAsal = (EditText)findViewById(R.id.edtFakultasAsal);
        programStudi = (EditText)findViewById(R.id.edtProgramStudiAsal);
        alamatUniv = (EditText)findViewById(R.id.edtAlamatUniv);
        kodeUniv = (EditText)findViewById(R.id.edtKodePosUniv);
        akre = (EditText)findViewById(R.id.edtAkreditas);
        IPK = (EditText)findViewById(R.id.edtIPK);
        ProvUniv = (Spinner) findViewById(R.id.spinnerProvinsiUniversitas);
        kotaUniv = (Spinner)findViewById(R.id.spinnerKotaUniversitas);

        String nameUn = nameUniv.getText().toString();
        String fkAsal = fakultasAsal.getText().toString();
        String prostud = programStudi.getText().toString();
        String univStreet = alamatUniv.getText().toString();
        String codeUniv = kodeUniv.getText().toString();
        String ak = akre.getText().toString();
        String value = IPK.getText().toString();
        String prUniv = ProvUniv.getSelectedItem().toString();
        String ktUniv = kotaUniv.getSelectedItem().toString();

        intent.putExtra("Name Universitas Asal", nameUn);
        intent.putExtra("Nama Fakultas Universitas Asal", fkAsal);
        intent.putExtra("Nama Program Studi Universitas Asal", prostud);
        intent.putExtra("Provinsi Univeristas", prUniv);
        intent.putExtra("Kota Universitas Asal", ktUniv);
        intent.putExtra("Alamat Universitas", univStreet);
        intent.putExtra("Kode Pos Universitas", codeUniv);
        intent.putExtra("Akreditas Universitas", ak);
        intent.putExtra("IPK", value);

        startActivity(intent);
    }
}
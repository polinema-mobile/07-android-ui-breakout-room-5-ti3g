package com.example.jobsheet7.models;

import android.os.Parcel;
import android.os.Parcelable;

public class mahasiswa implements Parcelable {
    private String name;
    private String nim;
    private String tanggalLahir;
    private String jenisKelamin;
    private String jurusan;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.nim);
        dest.writeString(this.tanggalLahir);
        dest.writeString(this.jenisKelamin);
        dest.writeString(this.jurusan);
    }

    public mahasiswa() {
    }

    public mahasiswa(String name, String nim, String tanggalLahir, String jenisKelamin, String jurusan) {
        this.name = name;
        this.nim = nim;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.jurusan = jurusan;
    }

    protected mahasiswa(Parcel in) {
        this.name = in.readString();
        this.nim = in.readString();
        this.tanggalLahir = in.readString();
        this.jenisKelamin = in.readString();
        this.jurusan = in.readString();
    }

    public static final Parcelable.Creator<mahasiswa> CREATOR = new Parcelable.Creator<mahasiswa>() {
        @Override
        public mahasiswa createFromParcel(Parcel source) {
            return new mahasiswa(source);
        }

        @Override
        public mahasiswa[] newArray(int size) {
            return new mahasiswa[size];
        }
    };
}

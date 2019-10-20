package com.google.ai.submison1;


import android.os.Parcel;
import android.os.Parcelable;

class Film implements Parcelable {
    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDiskripsi() {
        return diskripsi;
    }

    public void setDiskripsi(String diskripsi) {
        this.diskripsi = diskripsi;
    }

    private int    photo;
    private String nama;
    private String diskripsi;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeString(this.nama);
        dest.writeString(this.diskripsi);
    }

    public Film() {
    }

    protected Film(Parcel in) {
        this.photo = in.readInt();
        this.nama = in.readString();
        this.diskripsi = in.readString();
    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}

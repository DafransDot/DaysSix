package com.example.dayssix;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ListModel implements Parcelable{
    private String NamaPlayer;
    private int FotoPlayer;
    private String UmurPlayer;
    private String NegaraPlayer;
    private String GajiPlayer;


    public ListModel(String namaPlayer, int fotoPlayer, String umurPlayer, String negaraPlayer, String gajiPlayer) {
        NamaPlayer = namaPlayer;
        FotoPlayer = fotoPlayer;
        UmurPlayer = umurPlayer;
        NegaraPlayer = negaraPlayer;
        GajiPlayer = gajiPlayer;

    }

    protected ListModel(Parcel in) {
        NamaPlayer = in.readString();
        FotoPlayer = in.readInt();
        UmurPlayer = in.readString();
        NegaraPlayer = in.readString();
        GajiPlayer = in.readString();
    }

    public static final Creator<ListModel> CREATOR = new Creator<ListModel>() {
        @Override
        public ListModel createFromParcel(Parcel in) {
            return new ListModel(in);
        }

        @Override
        public ListModel[] newArray(int size) {
            return new ListModel[size];
        }
    };

    public String getNamaPlayer() {
        return NamaPlayer;
    }

    public void setNamaPlayer(String namaPlayer) {
        NamaPlayer = namaPlayer;
    }

    public int getFotoPlayer() {
        return FotoPlayer;
    }

    public void setFotoPlayer(int fotoPlayer) {
        FotoPlayer = fotoPlayer;
    }

    public String getUmurPlayer() {
        return UmurPlayer;
    }

    public void setUmurPlayer(String umurPlayer) {
        UmurPlayer = umurPlayer;
    }

    public String getNegaraPlayer() {
        return NegaraPlayer;
    }

    public void setNegaraPlayer(String negaraPlayer) {
        NegaraPlayer = negaraPlayer;
    }

    public String getGajiPlayer() {
        return GajiPlayer;
    }

    public void setGajiPlayer(String gajiPlayer) {
        GajiPlayer = gajiPlayer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(NamaPlayer);
        dest.writeInt(FotoPlayer);
        dest.writeString(UmurPlayer);
        dest.writeString(NegaraPlayer);
        dest.writeString(GajiPlayer);
    }
}

package com.example.myapplication.ui.models;


import android.os.Parcel;
import android.os.Parcelable;

public class SummaryData implements Parcelable {

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public int getTg() {
        return tg;
    }

    public void setTg(int tg) {
        this.tg = tg;
    }

    public int getTgp() {
        return tgp;
    }

    public void setTgp(int tgp) {
        this.tgp = tgp;
    }

    public int getDg() {
        return dg;
    }

    public void setDg(int dg) {
        this.dg = dg;
    }

    public int getDgp() {
        return dgp;
    }

    public void setDgp(int dgp) {
        this.dgp = dgp;
    }

    public int getInv() {
        return inv;
    }

    public void setInv(int inv) {
        this.inv = inv;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int iv) {
        this.lv = iv;
    }

    String nm;
    int tg;
    int tgp;
    int dg;
    int dgp;
    int inv;
    int lv;

    protected SummaryData(Parcel in) {
        nm = in.readString();
        tg = in.readInt();
        tgp = in.readInt();
        dg = in.readInt();
        dgp = in.readInt();
        inv = in.readInt();
        lv = in.readInt();
    }

    public static final Creator<SummaryData> CREATOR = new Creator<SummaryData>() {
        @Override
        public SummaryData createFromParcel(Parcel in) {
            return new SummaryData(in);
        }

        @Override
        public SummaryData[] newArray(int size) {
            return new SummaryData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nm);
        parcel.writeInt(tg);
        parcel.writeInt(tgp);
        parcel.writeInt(dg);
        parcel.writeInt(dgp);
        parcel.writeInt(inv);
        parcel.writeInt(lv);
    }
}

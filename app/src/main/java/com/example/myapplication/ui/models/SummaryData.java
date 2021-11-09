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

    public String getTg() {
        return "₹"+tg;
    }

    public void setTg(String tg) {
        this.tg = tg;
    }

    public String getTgp() {
        return tgp;
    }

    public void setTgp(String tgp) {
        this.tgp = tgp;
    }

    public String getDg() {
        return "₹"+dg;
    }

    public void setDg(String dg) {
        this.dg = dg;
    }

    public String getDgp() {
        return dgp;
    }

    public void setDgp(String dgp) {
        this.dgp = dgp;
    }

    public String getInv() {
        return "₹"+inv;
    }

    public void setInv(String inv) {
        this.inv = inv;
    }

    public String getLv() {
        return "₹"+lv;
    }

    public void setLv(String iv) {
        this.lv = iv;
    }

    public String getQn() {
        return qn;
    }

    public void setQn(String iv) {
        this.qn = qn;
    }

    public String getSp() {
        return "₹"+sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }
    String nm;
    String tg;
    String tgp;
    String dg;
    String dgp;
    String inv;
    String lv;
    String qn;
    String sp;

    protected SummaryData(Parcel in) {
        nm = in.readString();
        tg = in.readString();
        tgp = in.readString();
        dg = in.readString();
        dgp = in.readString();
        inv = in.readString();
        lv = in.readString();
        qn = in.readString();
        sp = in.readString();
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
        parcel.writeString(tg);
        parcel.writeString(tgp);
        parcel.writeString(dg);
        parcel.writeString(dgp);
        parcel.writeString(inv);
        parcel.writeString(lv);
        parcel.writeString(qn);

        parcel.writeString(sp);
    }
}

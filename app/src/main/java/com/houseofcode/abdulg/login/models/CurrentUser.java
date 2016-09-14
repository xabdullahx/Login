package com.houseofcode.abdulg.login.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Abdullah on 13-09-2016.
 */
public class CurrentUser implements Parcelable {

    public User user;
    public Oat_Bran oat_bran;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Oat_Bran getOat_bran() {
        return oat_bran;
    }

    public void setOat_bran(Oat_Bran oat_bran) {
        this.oat_bran = oat_bran;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.user, flags);
        dest.writeParcelable(this.oat_bran, flags);
    }

    public CurrentUser() {
    }

    protected CurrentUser(Parcel in) {
        this.user = in.readParcelable(User.class.getClassLoader());
        this.oat_bran = in.readParcelable(Oat_Bran.class.getClassLoader());
    }

    public static final Creator<CurrentUser> CREATOR = new Creator<CurrentUser>() {
        @Override
        public CurrentUser createFromParcel(Parcel source) {
            return new CurrentUser(source);
        }

        @Override
        public CurrentUser[] newArray(int size) {
            return new CurrentUser[size];
        }
    };
}

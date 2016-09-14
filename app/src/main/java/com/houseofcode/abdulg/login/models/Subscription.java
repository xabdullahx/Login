package com.houseofcode.abdulg.login.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Abdullah on 13-09-2016.
 */
public class Subscription implements Parcelable {
    private Integer id;
    private Date expires;
    private Date created_at;
    private Date updated_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeLong(this.expires != null ? this.expires.getTime() : -1);
        dest.writeLong(this.created_at != null ? this.created_at.getTime() : -1);
        dest.writeLong(this.updated_at != null ? this.updated_at.getTime() : -1);
    }

    public Subscription() {
    }

    protected Subscription(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        long tmpExpires = in.readLong();
        this.expires = tmpExpires == -1 ? null : new Date(tmpExpires);
        long tmpCreated_at = in.readLong();
        this.created_at = tmpCreated_at == -1 ? null : new Date(tmpCreated_at);
        long tmpUpdated_at = in.readLong();
        this.updated_at = tmpUpdated_at == -1 ? null : new Date(tmpUpdated_at);
    }

    public static final Parcelable.Creator<Subscription> CREATOR = new Parcelable.Creator<Subscription>() {
        @Override
        public Subscription createFromParcel(Parcel source) {
            return new Subscription(source);
        }

        @Override
        public Subscription[] newArray(int size) {
            return new Subscription[size];
        }
    };
}

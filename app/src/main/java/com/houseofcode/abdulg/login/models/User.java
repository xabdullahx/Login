package com.houseofcode.abdulg.login.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Abdullah on 13-09-2016.
 */
public class User implements Parcelable {
    private Boolean success;
    private Integer id;
    private String authentication_token;
    private String name;
    private String email;
    private Date member_since;
    private Date created_at;
    private Date updated_at;
    private Boolean has_access;
    private Subscription subscription;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthentication_token() {
        return authentication_token;
    }

    public void setAuthentication_token(String authentication_token) {
        this.authentication_token = authentication_token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getMember_since() {
        return member_since;
    }

    public void setMember_since(Date member_since) {
        this.member_since = member_since;
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

    public Boolean getHas_access() {
        return has_access;
    }

    public void setHas_access(Boolean has_access) {
        this.has_access = has_access;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.success);
        dest.writeValue(this.id);
        dest.writeString(this.authentication_token);
        dest.writeString(this.name);
        dest.writeString(this.email);
        dest.writeLong(this.member_since != null ? this.member_since.getTime() : -1);
        dest.writeLong(this.created_at != null ? this.created_at.getTime() : -1);
        dest.writeLong(this.updated_at != null ? this.updated_at.getTime() : -1);
        dest.writeValue(this.has_access);
        dest.writeParcelable(this.subscription, flags);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.success = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.authentication_token = in.readString();
        this.name = in.readString();
        this.email = in.readString();
        long tmpMember_since = in.readLong();
        this.member_since = tmpMember_since == -1 ? null : new Date(tmpMember_since);
        long tmpCreated_at = in.readLong();
        this.created_at = tmpCreated_at == -1 ? null : new Date(tmpCreated_at);
        long tmpUpdated_at = in.readLong();
        this.updated_at = tmpUpdated_at == -1 ? null : new Date(tmpUpdated_at);
        this.has_access = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.subscription = in.readParcelable(Subscription.class.getClassLoader());
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}

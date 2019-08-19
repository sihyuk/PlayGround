package com.example.androidplayground.Model;

import com.google.gson.annotations.SerializedName;

public class Contact {
    @SerializedName("name")
    private String name;

    @SerializedName("password")
    private String password;

    @SerializedName("username")
    private String username;

    @SerializedName("emailid")
    private String emailid;


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }


    public String getEmailid() {
        return emailid;
    }
}

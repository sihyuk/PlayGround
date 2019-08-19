package com.example.androidplayground;

import com.example.androidplayground.Model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("customer")
    Call<List<Contact>> getContacts();
}

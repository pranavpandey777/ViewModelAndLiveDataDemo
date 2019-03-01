package com.example.viewmodelandlivedatademo;


import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BaseUrl = "https://form420.000webhostapp.com/";

    @GET("getusers")
    Call<DataList> getuser();
}

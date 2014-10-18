package com.example.retrofitdemo.model;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface AddService {

	  @GET("/{json}")
	  void listAddress(@Path("json") String json, @Query("address") String address, @Query("region") String region, Callback<AddModel> addCallback);
}

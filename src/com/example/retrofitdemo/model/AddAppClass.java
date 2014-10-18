package com.example.retrofitdemo.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RequestInterceptor.RequestFacade;
import android.app.Application;

public class AddAppClass extends Application {
	
	public static final String API_URL = "http://maps.google.com/maps/api/geocode";

	public AddService service;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();

		
		RestAdapter restAdapter = new RestAdapter.Builder()
				.setLogLevel(RestAdapter.LogLevel.FULL)
				.setEndpoint(API_URL)
				.build();

		//service = restAdapter.create(ContactService.class);
		service = restAdapter.create(AddService.class);
		

	}

	public AddService getAddressService() {
		return service;
	}
}
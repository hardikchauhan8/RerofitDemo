package com.example.retrofitdemo.model;

import com.google.gson.annotations.SerializedName;

public class LatLngModel {

	@SerializedName("lat")
	public String lat;
	
	@SerializedName("lng")
	public String lng;
}

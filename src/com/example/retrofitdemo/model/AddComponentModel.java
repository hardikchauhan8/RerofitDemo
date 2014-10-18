package com.example.retrofitdemo.model;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class AddComponentModel {
	@SerializedName("address_components")
	public ArrayList<AddDetail> addComponents;

	@SerializedName("formatted_address")
	public String formattedAddress;
	
	@SerializedName("geometry")
	public LocationModel geometry;
}

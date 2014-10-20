package com.example.retrofitdemo.model;

import android.app.ActionBar;

import com.google.gson.annotations.SerializedName;

public class AddDetail {

	@SerializedName("long_name")
	public String long_name;
	
	@SerializedName("short_name")
	public String short_name;
}

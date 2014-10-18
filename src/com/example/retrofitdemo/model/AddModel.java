package com.example.retrofitdemo.model;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class AddModel {

	@SerializedName("results")
	public ArrayList<AddComponentModel> addresses;	
}
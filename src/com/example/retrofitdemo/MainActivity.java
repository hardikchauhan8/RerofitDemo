package com.example.retrofitdemo;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.retrofitdemo.model.AddAppClass;
import com.example.retrofitdemo.model.AddComponentModel;
import com.example.retrofitdemo.model.AddDetail;
import com.example.retrofitdemo.model.AddModel;
import com.example.retrofitdemo.model.AddService;

public class MainActivity extends Activity {

	private AddAppClass app;
	private EditText et1, et2;
	private Button btn1, btn2;
	private TextView tv1,tv2,tv3,tv4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et1 = (EditText) findViewById(R.id.editText1);
		et2 = (EditText) findViewById(R.id.editText2);
		btn1 = (Button) findViewById(R.id.button2);
		btn2 = (Button) findViewById(R.id.button1);
		tv1 = (TextView)findViewById(R.id.textView1);
		tv2 = (TextView)findViewById(R.id.textView2);
		tv3 = (TextView)findViewById(R.id.textView3);
		tv4 = (TextView)findViewById(R.id.textView4);

		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
			
				app = (AddAppClass) getApplication();
				AddService service = app.getAddressService();
				service.listAddress("json", "ahmedabad", "india",
						new Callback<AddModel>() {

							@Override
							public void failure(RetrofitError arg0) {
						
								Log.e("error", arg0.toString());
							}

							@Override
							public void success(AddModel adds, Response arg1) {

								ArrayList<AddComponentModel> list = adds.addresses;

								for (int i = 0; i < list.size(); i++) {
									ArrayList<AddDetail> list1 = list.get(i).addComponents;
									for (int j = 0; j < list.size(); j++) {
										Log.e("Name",
												list1.get(j).long_name);
										tv1.setText("Name : " + list1.get(j).long_name);
									}
									
									String lat = list.get(i).geometry.latLng.lat;
									String lng = list.get(i).geometry.latLng.lng;
									Log.e("Formetted Address",list.get(i).formattedAddress);
									Log.e("Latitude",lat);
									Log.e("longitude",lng);
									
									tv2.setText("Formetted Address : " + list.get(i).formattedAddress);
									tv3.setText("Latitude : " + list.get(i).geometry.latLng.lat);
									tv4.setText("Longitude : " + list.get(i).geometry.latLng.lng);
								}

							}

						});
			}
		});
		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				app = (AddAppClass) getApplication();
				AddService service = app.getAddressService();
				service.listAddress("json", et1.getText().toString(), et2
						.getText().toString(), new Callback<AddModel>() {

					@Override
					public void failure(RetrofitError arg0) {
						
						Log.e("error", arg0.toString());
					}

					@Override
					public void success(AddModel adds, Response arg1) {

						ArrayList<AddComponentModel> list = adds.addresses;

						for (int i = 0; i < list.size(); i++) {
							ArrayList<AddDetail> list1 = list.get(i).addComponents;
							for (int j = 0; j < list.size(); j++) {
								Log.e("Name",
										list1.get(j).long_name);
								tv1.setText("Name : " + list1.get(j).long_name);
							}
							String lat = list.get(i).geometry.latLng.lat;
							String lng = list.get(i).geometry.latLng.lng;
							Log.e("Formetted Address",list.get(i).formattedAddress);
							Log.e("Latitude",lat);
							Log.e("Latitude",lng);
							
							tv2.setText("Formetted Address : " + list.get(i).formattedAddress);
							tv3.setText("Latitude : " + list.get(i).geometry.latLng.lat);
							tv4.setText("Longitude : " + list.get(i).geometry.latLng.lng);
						}
					}

				});
			}
		});

	}
}
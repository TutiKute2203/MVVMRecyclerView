package com.example.chauntm.retrofitexample;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Chauntm on 4/28/2016.
 */
public class ServiceFactory {

	public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(endPoint)
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		T service = retrofit.create(clazz);

		return service;
	}
}

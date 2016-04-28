package com.example.chauntm.retrofitexample;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Chauntm on 4/28/2016.
 */
public class ServiceFactory {

	private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

	public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {
		httpClient.addInterceptor(new Interceptor() {
			@Override
			public Response intercept(Chain chain) throws IOException {
				Request original = chain.request();
				HttpUrl originalHttpUrl = original.url();

				HttpUrl url = originalHttpUrl.newBuilder()
						.addQueryParameter("appid", Constant.appId)
						.build();
				Request.Builder requestBuilder = original.newBuilder()
						.url(url)
						.method(original.method(), original.body());

				Request request = requestBuilder.build();
				return chain.proceed(request);
			}
		});

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(endPoint)
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.client(httpClient.build())
				.build();
		T service = retrofit.create(clazz);

		return service;
	}
}

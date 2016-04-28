package com.example.chauntm.retrofitexample;

import com.example.chauntm.data.CurrentWeather;
import com.example.chauntm.data.Forecast;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Chauntm on 4/28/2016.
 */
public interface WeatherService {
	String SERVICE_ENDPOINT = "http://api.openweathermap.org/data/2.5/";

	@GET("weather?")
	Observable<CurrentWeather> getWheatherReport(@Query("q") String city);

	@GET("forecast?mode=json&")
	Observable<Forecast> getForecast(@Query("q") String city);
}

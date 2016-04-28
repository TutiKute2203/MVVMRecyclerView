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

	@GET("weather?appid=312df3766af981efa13d42ee3e42d310&")
	Observable<CurrentWeather> getWheatherReport(@Query("q") String city);

	@GET("forecast?appid=312df3766af981efa13d42ee3e42d310&mode=json&")
	Observable<Forecast> getForecast(@Query("q") String city);
}

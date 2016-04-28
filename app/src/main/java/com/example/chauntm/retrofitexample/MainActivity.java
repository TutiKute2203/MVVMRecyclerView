package com.example.chauntm.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.chauntm.data.CurrentWeather;
import com.example.chauntm.data.Forecast;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

	final WeatherService service = ServiceFactory.createRetrofitService(WeatherService.class, WeatherService.SERVICE_ENDPOINT);
	final String TAG = MainActivity.class.getSimpleName();

	@Bind(R.id.txt_city) TextView mCityTV;
	@Bind(R.id.txt_status) TextView mStatusTV;
	@Bind(R.id.txt_humidity) TextView mHumidityTV;
	@Bind(R.id.txt_press) TextView mPressureTV;
	@Bind(R.id.txt_forecast) TextView mForecastTV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ButterKnife.bind(this);
		getWeather();
		getForecast();
	}

	private void getWeather() {
		Observable<CurrentWeather> currentWeather = service.getWheatherReport("London");
		currentWeather.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Subscriber<CurrentWeather>() {
					@Override
					public void onCompleted() {

					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onNext(CurrentWeather currentWeather) {
						mCityTV.setText("city  :  " + currentWeather.getName());
						mStatusTV.setText("status : " + currentWeather.getWeather().get(0).getDescription());
						mHumidityTV.setText("humidity : " + currentWeather.getMain().getHumidity().toString());
						mPressureTV.setText("pressure : " + currentWeather.getMain().getPressure());
					}
				});
	}

	private void getForecast() {
		service.getForecast("London").subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Subscriber<Forecast>() {
					@Override
					public void onCompleted() {
						Log.i(TAG, "onCompleted: ");
					}

					@Override
					public void onError(Throwable e) {
						Log.e(TAG, "onError: " + e.getMessage());
					}

					@Override
					public void onNext(Forecast forecast) {
						Log.i(TAG, "onNext: ");
						mForecastTV.setText("forecast : " + forecast.getCity().getCountry());
					}
				});
	}

}

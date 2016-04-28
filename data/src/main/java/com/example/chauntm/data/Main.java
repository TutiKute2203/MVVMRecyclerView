package com.example.chauntm.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Chauntm on 4/27/2016.
 */
public class Main {
	@SerializedName("temp")
	@Expose
	private float temp;
	@SerializedName("pressure")
	@Expose
	private float pressure;
	@SerializedName("humidity")
	@Expose
	private Integer humidity;
	@SerializedName("temp_min")
	@Expose
	private float temp_min;
	@SerializedName("temp_max")
	@Expose
	private float temp_max;
	@SerializedName("sea_level")
	@Expose
	private Double seaLevel;
	@SerializedName("grnd_level")
	@Expose
	private Double grndLevel;
	@SerializedName("temp_kf")
	@Expose
	private float tempKf;

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public float getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(float temp_min) {
		this.temp_min = temp_min;
	}

	public float getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(float temp_max) {
		this.temp_max = temp_max;
	}

	public Double getSeaLevel() {
		return seaLevel;
	}

	public void setSeaLevel(Double seaLevel) {
		this.seaLevel = seaLevel;
	}

	public Double getGrndLevel() {
		return grndLevel;
	}

	public void setGrndLevel(Double grndLevel) {
		this.grndLevel = grndLevel;
	}

	public float getTempKf() {
		return tempKf;
	}

	public void setTempKf(float tempKf) {
		this.tempKf = tempKf;
	}
}

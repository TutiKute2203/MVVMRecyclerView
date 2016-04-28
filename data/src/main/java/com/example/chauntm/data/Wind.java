package com.example.chauntm.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Chauntm on 4/27/2016.
 */
public class Wind {
	@SerializedName("speed")
	@Expose
	private float speed;
	@SerializedName("deg")
	@Expose
	private float deg;

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getDeg() {
		return deg;
	}

	public void setDeg(float deg) {
		this.deg = deg;
	}
}

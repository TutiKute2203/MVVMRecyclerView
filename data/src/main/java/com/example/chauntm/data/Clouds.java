package com.example.chauntm.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Chauntm on 4/27/2016.
 */

public class Clouds {
	@SerializedName("all")
	@Expose
	private int all;

	public int getAll() {
		return all;
	}

	public void setAll(int all) {
		this.all = all;
	}
}

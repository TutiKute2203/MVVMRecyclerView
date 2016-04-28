package com.example.chauntm.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 4/28/2016.
 */
public class Sys_ {
	@SerializedName("pod")
	@Expose
	private String pod;

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}
}

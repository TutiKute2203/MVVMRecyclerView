package com.example.chauntm.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 4/28/2016.
 */
public class City {

	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("coord")
	@Expose
	private Coordinate coord;
	@SerializedName("country")
	@Expose
	private String country;
	@SerializedName("population")
	@Expose
	private Integer population;
	@SerializedName("sys")
	@Expose
	private System sys;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coordinate getCoord() {
		return coord;
	}

	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public System getSys() {
		return sys;
	}

	public void setSys(System sys) {
		this.sys = sys;
	}
}

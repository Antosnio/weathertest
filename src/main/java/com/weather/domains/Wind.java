package com.weather.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {

	private double speed;
	private int deb;

	public Wind() {

	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getDeb() {
		return deb;
	}

	public void setDeb(int deb) {
		this.deb = deb;
	}

	@Override
	public String toString() {
		return "Wind{" + "windspeed='" + speed + '\'' + '}';
	}
}

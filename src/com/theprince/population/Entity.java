package com.theprince.population;

public class Entity {
	public double purse;
	public double radical; // TODO this should cover conservative as well
	public double conservative;
	public double fatigue;
	public Entity(double purse, double radical, double conservative, double fatigue) {
		this.purse = purse;
		this.radical = radical;
		this.conservative = conservative;
		this.fatigue = fatigue;
	}
}

package com.theprince.population;

public class Population extends Entity {
	public int size;
	public double innovation;
	public double technology; // Better name is order.
	public double purloinedTechnology;
	public double resources;
	public double regulation;
	public Population(int size, double purse, double radical, double conservative) {
		super(purse, radical, conservative);
		this.size = size;
	}
}
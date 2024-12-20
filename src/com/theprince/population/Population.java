package com.theprince.population;

import java.util.ArrayList;

import com.theprince.population.attributes.Att;

public class Population extends Entity {
	public int size;
	public double innovation;
	public double technology;
	public double newTechnology;
	public double resources;
	public double regulation;
	public Population(int size, ArrayList<Att> attrs) {
		super(attrs);
		this.size = size;
	}
}
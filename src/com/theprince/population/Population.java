package com.theprince.population;

import java.util.ArrayList;

import com.theprince.population.attributes.Att;

public class Population extends Entity {
	public int size;
	public Population(int size, ArrayList<Att> attrs) {
		super(attrs);
		this.size = size;
	}
}
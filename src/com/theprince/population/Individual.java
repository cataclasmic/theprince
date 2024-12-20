package com.theprince.population;

import java.util.ArrayList;

import com.theprince.population.attributes.Att;

public class Individual extends Entity {
	public Population population;
	public String name;
	public Individual(String name, ArrayList<Att> attrs, Population population) {
		super(attrs);
		this.name = name;
		this.population = population;
	}
}

package com.theprince.population;

import java.util.ArrayList;

import com.theprince.population.attributes.Attribute;

public class Population extends Entity {
	public int size;
	public ArrayList<Attribute> attrs = new ArrayList<Attribute>();
	public Population(int size, ArrayList<Attribute> attrs) {
		this.size = size;
		this.attrs = attrs;
	}
}
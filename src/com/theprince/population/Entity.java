package com.theprince.population;

import java.util.ArrayList;

import com.theprince.population.attributes.Att;

public class Entity {
	ArrayList<Att> attrs = new ArrayList<Att>();
	public double purse;
	public Entity(ArrayList<Att> attrs) {
		this.attrs = attrs;
		this.purse = 0;
	}
	
	public Entity(ArrayList<Att> attrs, double purse) {
		this(attrs);
		this.purse = purse;
	}
}

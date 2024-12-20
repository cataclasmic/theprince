package com.theprince.population;

import java.util.ArrayList;

import com.theprince.population.attributes.Att;

public class Entity {
	ArrayList<Att> attrs = new ArrayList<Att>();
	public Entity(ArrayList<Att> attrs) {
		this.attrs = attrs;
	}
}

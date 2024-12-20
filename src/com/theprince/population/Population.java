package com.theprince.population;

import java.util.ArrayList;

public class Population {
	public int size;
	public ArrayList<Attribute> attrs = new ArrayList<Attribute>();
	public Population(int size, ArrayList<Attribute> attrs) {
		this.size = size;
		this.attrs = attrs;
	}

}

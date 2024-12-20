package com.theprince.population;

public class King extends Individual {
	public double authority;
	public String name;
	public King(String name, double authority, Population population) {
		super(population);
		this.name = name;
		this.authority = authority;
	}
}

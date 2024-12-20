package com.theprince.population;

public class Individual extends Entity {
	public Population population;
	public String name;
	public Individual(String name, Population population) {
		this.name = name;
		this.population = population;
	}
}

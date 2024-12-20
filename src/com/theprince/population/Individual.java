package com.theprince.population;

public class Individual extends Entity {
	public static int CHARISMA_RANGE = 100;
	public Population population;
	public enum Strategy { POWER, POPULARITY, WEALTH, BALANCED };
	public Strategy strategery;
	public double charisma; // Threshold for getting deposed.
	public Individual(Strategy strategery, double charisma, Population population, double purse, double radical, double conservative, double fatigue) {
		super(purse, radical, conservative, fatigue);
		this.strategery = strategery;
		this.charisma = charisma;
		this.population = population;
	}
}

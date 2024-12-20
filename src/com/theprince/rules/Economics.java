package com.theprince.rules;

import java.util.ArrayList;

import com.theprince.population.Population;

public class Economics {
	public static void process(ArrayList<Population> pops) {
		// Add new technology.
		for (Population pop : pops) {
			for (Population otherPop : pops) {
				if (otherPop == pop) continue;
				double newTechnology = otherPop.technology - pop.regulation;
				if (newTechnology > 0) {
					pop.newTechnology += newTechnology;
				}
			}
		}
		
		// Update population economics. 
		for (Population pop : pops) {
			pop.innovation += pop.size - pop.regulation;
			pop.technology += pop.innovation;
			pop.purse += pop.technology * pop.resources;
			pop.resources -= pop.size / pop.technology;
			pop.size += pop.purse * pop.technology;
			pop.purse -= pop.size;
		}
	}
}

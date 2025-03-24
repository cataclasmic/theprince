package com.theprince.rules;

import java.util.ArrayList;
import java.math.*;

import com.theprince.population.Population;

public class Economics {
	public static void process(ArrayList<Population> pops) {
		// Add new technology based on surrounding populations.
		for (Population pop : pops) {
			pop.resources += pop.purloinedTechnology; // Surrounding technology increases the population's resources, but effect is delayed.
			pop.purloinedTechnology = 0;
			for (Population otherPop : pops) {
				if (otherPop == pop) continue;
				pop.purloinedTechnology += otherPop.technology;
			}
		}
		
		// Update population economics.
		// Innovation is the top derivative for creating wealth, and is a function of how unregulated the population is.
		// Technology is created by unhampered innovation, as well as purloined from surrounding populations, which is also obstructed by regulation.
		// Resources are necessary for creating wealth, but are also depleted by the population.
		for (Population pop : pops) {
			pop.innovation += Math.max(0.0, pop.size - pop.regulation);
			double obstruction = pop.regulation/1000 * pop.size; 
			pop.technology += Math.max(0.0, pop.innovation + pop.purloinedTechnology - obstruction);
			pop.purse += Math.max(pop.technology * pop.resources/pop.size, 0);
			pop.resources = Math.max(pop.resources - pop.size / pop.technology + (pop.purse * pop.technology)/pop.size, 0);
			pop.size = (int) Math.max(pop.size + pop.resources/pop.size - 1, 0);
			pop.purse = Math.max(0, pop.purse - pop.size);
		}
		
		// The population values change based on situation.
		// If there is a lot of money or regulation, then the population becomes more radical, i.e. more willing to change.
		// If there is not much money, then the population will become more conservative, less willing to change.
		for (Population pop : pops) {
			pop.radical += (pop.purse + pop.regulation)/pop.size;
			pop.conservative += Math.abs(pop.purse-pop.size);
		}
	}
	
	public static void main(String[] args) {
		
	}
}

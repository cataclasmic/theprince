package com.theprince.rules;

import java.util.ArrayList;
import java.util.Random;
import java.math.*;

import com.theprince.population.Individual;
import com.theprince.population.Population;

public class Rulership {
	public static void process(ArrayList<Individual> rulers) {
		ArrayList<Individual> deposedRulers = new ArrayList<Individual>();
		ArrayList<Individual> newRulers = new ArrayList<Individual>();
		for(Individual ruler : rulers) {
			// A ruler is disliked by his population based on the population size, and how much his radicalism and conservativism diverges from the population.
			Population pop = ruler.population;
			double dislike = Math.abs(ruler.radical - pop.radical) + Math.abs(ruler.conservative - pop.conservative) * pop.size;
			// Dislike can be countered by regulation of the population.
			if (dislike - ruler.population.regulation > ruler.charisma) {
				// Deposing the ruler resets the ruler to match the population character, but erases technology and regulation.
				pop.technology = 0;
				pop.regulation = 0;
				deposedRulers.add(ruler);
				// New rulers start out poor and with the same characteristics as their population.  New ruler also will have a different strategy.
				Individual.Strategy newStrategery = null;
				switch(ruler.strategery) {
				case POWER:
					newStrategery = Individual.Strategy.POPULARITY;
					break;
				case POPULARITY:
					newStrategery = Individual.Strategy.WEALTH;
					break;
				case WEALTH:
					newStrategery = Individual.Strategy.POWER;
					break;
				}
				// New ruler will be more charismatic than the old.
				double newCharisma = Math.min(ruler.charisma + 10, Individual.CHARISMA_RANGE);
				newRulers.add(new Individual(newStrategery, newCharisma, pop, 0.0, pop.radical, pop.conservative, 50));
			} else {
				// Ruler has three maximization strategies:
				// 1. power (popularity and regulation)
				// 2. popularity (correspondence between ruler and population)
				// 3. wealth (regulation)
				switch(ruler.strategery) {
				case POWER:
					ruler.radical = pop.radical;
					ruler.conservative = pop.conservative;
					pop.regulation += 10;
					ruler.conservative = 0.9 * ruler.conservative + 0.1 * pop.regulation/(pop.size+pop.regulation);
					ruler.charisma = Math.max(1, ruler.charisma - 2);
					break;
				case POPULARITY:
					ruler.radical = pop.radical;
					ruler.conservative = pop.conservative;
					ruler.charisma += 1;
					break;
				case WEALTH:
					pop.regulation += 10;
					ruler.conservative = 0.9 * ruler.conservative + 0.1 * pop.regulation/(pop.size+pop.regulation);
					break;
				}
				
				ruler.purse += Math.min(pop.purse, pop.regulation);
				pop.purse = Math.max(0, pop.purse - pop.regulation);
			}
		}
		rulers.removeAll(deposedRulers);
		rulers.addAll(newRulers);
	}
}

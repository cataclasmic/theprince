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
				// New rulers start out poor and with the same characteristics as their population.
				Individual.Strategy newStrategery = Individual.Strategy.values()[new Random().nextInt(Individual.Strategy.values().length)];
				newRulers.add(new Individual(newStrategery, new Random().nextInt(Individual.CHARISMA_RANGE), pop, 0.0, pop.radical, pop.conservative));
			} else {
				// Ruler has three maximization strategies:
				// 1. power (popularity and regulation)
				// 2. popularity (correspondence between ruler and population)
				// 3. wealth (regulation)
				switch(ruler.strategery) {
				case POWER:
					pop.regulation += 10;
					ruler.radical = pop.radical;
					ruler.conservative = pop.conservative;
					break;
				case POPULARITY:
					ruler.radical = pop.radical;
					ruler.conservative = pop.conservative;
					break;
				case WEALTH:
					pop.regulation += 10;
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

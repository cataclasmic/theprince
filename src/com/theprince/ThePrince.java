package com.theprince;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

import com.theprince.population.Individual;
import com.theprince.population.Population;

import com.theprince.rules.Economics;

public class ThePrince {
	static LocalDateTime START_DATETIME = LocalDateTime.of(1513, 1, 1, 8, 0);
	public static void main(String args[])
	{
		System.out.println("The Prince");
		ArrayList<Population> pops = new ArrayList<Population>();
		Population kingdom = new Population(100, 1000, .1, .5, 50);
		pops.add(kingdom);
		Individual you = new Individual(Individual.Strategy.BALANCED, 50, kingdom, 100, 0, 0, 50);
		
		Scanner input = new Scanner(System.in);
		
		LocalDateTime when = START_DATETIME;
		long daysPassed = 0;
		
		Menu mainMenu = new Menu();
		mainMenu.add('e', "End Day", null);
		boolean gameover = false;
		while (!gameover)
		{
			System.out.println(when.toString());
			System.out.println("*** POPULATION ***");
			you.population.display();
			System.out.println("*** YOU ***");
			you.display();
			System.out.print(mainMenu.getDisplay() + "\n>");
			char in = input.nextLine().charAt(0);
			
			switch (in)
			{
			case 'e':
		    		LocalDateTime newWhen = when.plus(Period.ofDays(1)).withHour(8);
		    		Duration d = Duration.between(when, newWhen);
		    		you.fatigue -= d.toHours() - 10; // 10 = "normal" hours of rest
		    		when = newWhen;
		    		break;
			case 'q':
				gameover = true;
				break;
		    }
		
			long newDaysPassed = ChronoUnit.DAYS.between(START_DATETIME, when);
			if (newDaysPassed > daysPassed)
			{
				daysPassed = newDaysPassed;
				Economics.process(pops);
			}
		}
	}
}

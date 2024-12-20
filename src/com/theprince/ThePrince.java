package com.theprince;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

import com.theprince.population.Individual;
import com.theprince.population.Population;
import com.theprince.population.attributes.Att;
import com.theprince.population.attributes.Conservative;
import com.theprince.population.attributes.Radical;
import com.theprince.rules.Economics;

public class ThePrince {
	static LocalDateTime START_DATETIME = LocalDateTime.of(1513, 1, 1, 8, 0);
	public static void main(String args[])
	{
		System.out.println("The Prince");
		ArrayList<Att> attrs = new ArrayList<Att>();
		attrs.add(new Conservative(0.5));
		attrs.add(new Radical(0.1));
		ArrayList<Population> pops = new ArrayList<Population>();
		Population kingdom = new Population(100, attrs);
		pops.add(kingdom);
		Individual you = new Individual("Fred", new ArrayList<Att>(), kingdom);
		
		Scanner input = new Scanner(System.in);
		
		LocalDateTime when = START_DATETIME;
		long daysPassed = 0;
		
		Menu mainMenu = new Menu();
		mainMenu.add('e', "End Day", null);
		while (true)
		{
			System.out.println(when.toString());
			System.out.print(mainMenu.getDisplay() + "\n>");
			char in = input.nextLine().charAt(0);
			
			switch (in)
			{
			case 'e':
		    		when = when.plus(Period.ofDays(1)).withHour(8);
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

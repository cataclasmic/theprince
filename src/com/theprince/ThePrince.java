package com.theprince;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import com.theprince.population.Individual;
import com.theprince.population.Population;
import com.theprince.population.attributes.Att;
import com.theprince.population.attributes.Conservative;
import com.theprince.population.attributes.Radical;

public class ThePrince {
  public static void main(String args[])
  {
    System.out.println("The Prince");
    ArrayList<Att> attrs = new ArrayList<Att>();
    attrs.add(new Conservative(0.5));
    attrs.add(new Radical(0.1));
    Population kingdom = new Population(100, attrs);  
    Individual you = new Individual("Fred", kingdom);
    
    Scanner input = new Scanner(System.in);
    
    LocalDateTime when = LocalDateTime.of(1513, 1, 1, 8, 0);
    
    Menu mainMenu = new Menu();
    mainMenu.add('s', "Sleep", null);
    while (true)
    {
    	System.out.println(when.toString());
    	System.out.print(mainMenu.getDisplay() + "\n>");
    	char in = input.nextLine().charAt(0);
    	
    	switch (in)
    	{
    	case 's':
    		when.plusHours(8);
    		break;
    	}
    	
    }
  }
}

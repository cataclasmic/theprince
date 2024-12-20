package com.theprince;

import java.util.ArrayList;

import com.theprince.population.King;
import com.theprince.population.Population;
import com.theprince.population.attributes.Attribute;
import com.theprince.population.attributes.Conservative;
import com.theprince.population.attributes.Radical;

public class ThePrince {
  public static void main(String args[])
  {
    System.out.println("The Prince");
    ArrayList<Attribute> attrs = new ArrayList<Attribute>();
    attrs.add(new Conservative(0.5));
    attrs.add(new Radical(0.1));
    Population kingdom = new Population(100, attrs);  
    King king = new King("Fred", 0.2, kingdom);
  }
}

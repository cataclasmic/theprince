package com.theprince;

import java.util.ArrayList;

public class Menu
{
	ArrayList<Item> items = new ArrayList<Item>();
	String display = "";
	
	public Menu add (char shortcut, String name, String title)
	{
		items.add(new Item(shortcut, name, title));
		display = null;
		
		return this;
	}
	
	void generateDisplay ()
	{
		display = "";
		for (Item i : items)
		{
			display += i.shortcut + ") " + i.getTitle() + "\t";
		}
	}
	
	public String getDisplay ()
	{
		if (display == null) generateDisplay();
		return display;
	}

	class Item
	{
		char shortcut;
		String name;
		String title = null;
		
		Item (char shortcut, String name, String title)
		{
			this.shortcut = shortcut;
			this.name = name;
			this.title = title;
		}
		
		String getTitle ()
		{
			return (title == null) ? name : title;
		}
	}
}


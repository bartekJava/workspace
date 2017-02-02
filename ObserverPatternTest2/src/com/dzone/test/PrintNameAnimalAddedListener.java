package com.dzone.test;

public class PrintNameAnimalAddedListener implements AnimalAddedListener
{
	@Override
	public void updateAnimalAdded(Animal animal) 
	{
		System.out.println("Added a new animal with name '" + animal.getName() + "'");
	}
}

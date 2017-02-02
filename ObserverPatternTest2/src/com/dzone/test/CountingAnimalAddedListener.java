package com.dzone.test;

public class CountingAnimalAddedListener implements AnimalAddedListener
{
	private static int animalsAddedCount = 0;

	@Override
	public void updateAnimalAdded(Animal animal) 
	{
		animalsAddedCount++;
		
		System.out.println("Total animals added: " + animalsAddedCount);
	}
	

}

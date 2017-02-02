package com.dzone.test;

public class Main 
{
	public static void main(String[] args) 
	{
		Zoo zoo = new Zoo();
		
		zoo.registerAnimalAddedListener(new PrintNameAnimalAddedListener());
		zoo.registerAnimalAddedListener(new CountingAnimalAddedListener());
		
		zoo.addAnimal(new Animal("Tiger"));
        zoo.addAnimal(new Animal("Lion"));
        zoo.addAnimal(new Animal("Bear"));
        
        
	}
}

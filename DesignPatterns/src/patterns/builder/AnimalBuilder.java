package patterns.builder;

import java.util.*;

public class AnimalBuilder
{
	private String species;
	private int age;
	private List<String> favoriteFoods;

	public AnimalBuilder setAge(int age)
	{
		this.age = age;
		return this;
	}

	public AnimalBuilder setSpecies(String species)
	{
		this.species = species;
		return this;
	}

	public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods)
	{
		this.favoriteFoods = favoriteFoods;
		return this;
	}

	public Animal build() //build() method may also set default values for anything the user failed to specify
	{
		return new Animal(species, age, favoriteFoods);
	}
}

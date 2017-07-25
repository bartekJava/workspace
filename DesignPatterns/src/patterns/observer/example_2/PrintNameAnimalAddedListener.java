package patterns.observer.example_2;

public class PrintNameAnimalAddedListener implements AnimalAddedListener
{
	@Override
	public void updateAnimalAdded(Animal animal) 
	{
		System.out.println("Added a new animal with name '" + animal.getName() + "'");
	}
}

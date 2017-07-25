package patterns.observer.example_2;

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

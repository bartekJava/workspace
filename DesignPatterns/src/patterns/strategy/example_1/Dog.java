package patterns.strategy.example_1;

public class Dog extends Animal
{
	private String name = "Azor";

	public Dog() 
	{
		super();
		this.name = name;
		
		flyingType = new CantFly();
	}
	
	

}

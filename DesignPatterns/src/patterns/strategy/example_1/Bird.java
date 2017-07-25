package patterns.strategy.example_1;

public class Bird extends Animal
{
	private String name = "Sroka";

	public Bird() 
	{
		super();
		this.name = name;
		
		flyingType = new ItFlys();
	}
	
	

}

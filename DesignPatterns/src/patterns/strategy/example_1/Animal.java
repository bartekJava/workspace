package patterns.strategy.example_1;

public class Animal 
{
	public Flys flyingType;
	
	
	public String tryToFly()
	{
		return flyingType.fly();
	}

	public void setFlyingType(Flys newFlyingType)
	{
		flyingType = newFlyingType;
	}
}

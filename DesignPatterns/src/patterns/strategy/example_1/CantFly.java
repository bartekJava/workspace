package patterns.strategy.example_1;

public class CantFly implements Flys
{
	@Override
	public String fly() 
	{
		return "I can't fly.";
	}
}

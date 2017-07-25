package patterns.strategy.example_2;

public class PayPalStrategy implements PaymentStrategy
{
	private String emailId;
	private String password;
	
	public PayPalStrategy(String emailId, String password) 
	{
		this.emailId = emailId;
		this.password = password;
	}

	@Override
	public void pay(int amount) 
	{
		System.out.println("Paid " + amount + " using PayPal");
	}
}

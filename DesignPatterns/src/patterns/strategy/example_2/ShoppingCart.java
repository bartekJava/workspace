package patterns.strategy.example_2;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart 
{
	private List<Item> listOfItems;
	
	public ShoppingCart()
	{
		this.listOfItems = new ArrayList<Item>();
	}
	
	public void addItem(Item item)
	{
		this.listOfItems.add(item);
	}
	
	public void removeItems(Item item)
	{
		this.listOfItems.remove(item);
	}
	
	public int calculateTotal()
	{
		int sum = 0;
		for(Item item : listOfItems)
		{
			sum = sum + item.getPrice();
		}
		
		return sum;
	}
	
	public void pay(PaymentStrategy strategy)
	{
		strategy.pay(calculateTotal());
	}

}

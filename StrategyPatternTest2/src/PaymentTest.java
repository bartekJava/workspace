
public class PaymentTest 
{
	public static void main(String[] args)
	{
		ShoppingCart shoppingCart = new ShoppingCart();
		
		Item item1 = new Item("1234", 20);
		Item item2 = new Item("4567", 50);
		
		shoppingCart.addItem(item1);
		shoppingCart.addItem(item2);
		
		shoppingCart.pay(new CreditCardStrategy("Jan", "4171741", "651", "02.20.2016"));
		
		shoppingCart.pay(new PayPalStrategy("sdfwf", "sadasdawdawd")); 
	}

}

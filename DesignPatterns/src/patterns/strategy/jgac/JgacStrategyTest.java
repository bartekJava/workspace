package patterns.strategy.jgac;

public class JgacStrategyTest {

	public static void main(String[] args) {
		
		Person person = new Person(10000000);
		Trust nonProfit = new Trust(10000000, true);
		Trust forProfit = new Trust(10000000, false);
		
		TaxStrategy<Person> defaultStrategy = new DefaultTaxStrategy<Person>();
		TaxStrategy<Person> dodgingStrategy = new DodgingTaxStrategy<Person>();
		assert defaultStrategy.computeTax(person) == 4000000;
		assert dodgingStrategy.computeTax(person) == 0;
		
		TaxStrategy<Trust> trustStrategy = new TrustTaxStrategy();
		assert trustStrategy.computeTax(nonProfit) == 0;
		assert trustStrategy.computeTax(forProfit) == 4000000;
		
//		trustStrategy.computeTax(person); //compile-time error
		
//		Without generics, the computeTax method of TrustTaxStrategy would have to accept
//		an argument of type TaxPayer and cast it to type Trust, and errors would throw an
//		exception at run time rather than be caught at compile time.

	}

}

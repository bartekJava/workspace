package patterns.strategy.jgac;

public class TrustTaxStrategy extends DefaultTaxStrategy<Trust>{
	
	public long computeTax(Trust trust) {
		return trust.isNonProfit() ? 0 : super.computeTax(trust);
		}

}

package patterns.strategy.jgac;

public class DodgingTaxStrategy<P extends TaxPayer> implements TaxStrategy<P> {

	public long computeTax(P p) {
		return 0;
	}

}

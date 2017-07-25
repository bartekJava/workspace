package patterns.strategy.jgac;

public interface TaxStrategy<P extends TaxPayer> {
	public long computeTax(P p);
}

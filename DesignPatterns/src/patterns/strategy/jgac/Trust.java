package patterns.strategy.jgac;

public class Trust extends TaxPayer {
	private boolean nonProfit;

	public Trust(long income, boolean nonProfit) {
		super(income);
		this.nonProfit = nonProfit;
	}

	public boolean isNonProfit() {
		return nonProfit;
	}
}
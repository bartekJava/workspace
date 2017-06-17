package finding.my.books;

public class DispRecord
{
	final String title;
	final int disp, length;
	DispRecord(String t, int d, int l) {
	this.title = t; this.disp = d; this.length = l;
	}
	int totalDisp() { return disp + length; }
}
package customer;

import Euro.Euro;

public class Statement implements IStatement {
	private IPrinter printer;
	private Euro total = new Euro(0);

	public Statement(IPrinter printer) {
		this.printer = printer;
	}

	public void printCustomerName(String name) {
		printer.print("Rental records for " + name);
		printer.crlf();
	}

	public void printMovieTitle(String title) {
		printer.tab();
		printer.print(title);
	}

	public void printMovieCharge(Euro charge) {
		printer.tab();
		printer.print(charge.format());
		printer.crlf();
		total = total.plus(charge);
	}

	public void printTotalCharge() {
		printer.print("Amount owed is " + total.format());
		printer.crlf();
		printer.cutPaper();
	}
}

package CabInvoiceGenerator;

public class InvoiceSummary {

	private int noOfRides;
	private double totalFare;
	private double avgFare;

	public InvoiceSummary(int noOfRides, double totalFare) {
		this.noOfRides = noOfRides;
		this.totalFare = totalFare;
		this.avgFare = this.totalFare / this.noOfRides;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		InvoiceSummary that = (InvoiceSummary) obj;
		return noOfRides == that.noOfRides && Double.compare(that.totalFare, totalFare) == 0
				&& Double.compare(that.avgFare, avgFare) == 0;
	}

	public String toString() {
		return "Summary: no. of ride: " + noOfRides + " avg fare:" + avgFare;
	}
}

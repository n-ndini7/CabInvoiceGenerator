package CabInvoiceGenerator;

import java.util.ArrayList;

//UC1 - calculate fare
//UC2 - refactored to take multiple rides 
//UC3 - Invoice summary added 
//UC4 - get the userId and the invoice service gets the list of rides
//UC5 - Premium rides added to the cab service
public class CabInvoiceService {

	public static final double MIN_COST_PER_KM_NORMAL = 10;
	public static final double COST_PER_TIME_NORMAL = 1;
	public static final double MIN_COST_PER_KM_PREMIUM = 15;
	public static final double COST_PER_TIME_PREMIUM = 2;
	public static final double MIN_FARE_PREMIUM = 20;
	public double fare;
	public double totalFare;
	public static final double MIN_FARE_NORMAL = 5;

	public double calculateFare(double dis, double time, int type) {
		if (type == 2) {
			fare = dis * MIN_COST_PER_KM_NORMAL + time * COST_PER_TIME_NORMAL;
			if (fare < MIN_FARE_NORMAL) {
				fare = MIN_FARE_NORMAL;
			}
		} else if (type == 1) {
			fare = dis * MIN_COST_PER_KM_PREMIUM + time * COST_PER_TIME_PREMIUM;
			if (fare < MIN_FARE_PREMIUM) {
				fare = MIN_FARE_PREMIUM;
			}
		}
		return fare;
	}

	public InvoiceSummary calculateFare(ArrayList<Ride> rides) {
		double totalFare = 0;
		int type = 0;
		for (Ride ride : rides) {
			if (ride.type.equalsIgnoreCase("PREMIUM_RIDE")) {
				type = 1;
			} else if (ride.type.equalsIgnoreCase("NORMAL_RIDE")) {
				type = 2;
			}
			totalFare += (this.calculateFare(ride.distance, ride.time, type));
		}
		return new InvoiceSummary(rides.size(), totalFare);
	}

}

package CabInvoiceGenerator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

//UC1 - calculate fare
//UC2 - refactored to take multiple rides 
public class CabInvoiceService {

	public static final double MIN_COST_PER_KM = 10;
	public static final double COST_PER_TIME = 1;
	public double fare;
	public double totalFare;
	public static final double MIN_FARE = 5;

	public double calculateFare(double dis, double time) {
		fare = dis * MIN_COST_PER_KM + time * COST_PER_TIME;
		if (fare < MIN_FARE) {
			fare = MIN_FARE;
		}
		return fare;
	}

	public double calculateFare(ArrayList<Ride> rides) {
		for (Ride ride : rides) {
			totalFare += calculateFare(ride.distance, ride.time);
		}
		return totalFare;
	}

}

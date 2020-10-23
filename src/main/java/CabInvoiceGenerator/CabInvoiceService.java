package CabInvoiceGenerator;

import java.util.Scanner;

//Master branch - welcome message
public class CabInvoiceService {

	public static final double MIN_COST_PER_KM = 10;
	public static final double COST_PER_TIME = 1;
	public static double fare;
	public static final double MIN_FARE = 5;

	public double calculateFare(double dis, double time) {
		this.fare = dis * MIN_COST_PER_KM + time * COST_PER_TIME;
		if (fare < MIN_FARE) {
			return MIN_FARE;
		}
		return fare;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Cab Invoice Service program!");
		System.out.println("Enter the distance(in kms): ");
		double distance = Double.parseDouble(sc.nextLine());
		System.out.println("Enter the time (in minutes): ");
		double time = Double.parseDouble(sc.nextLine());
		CabInvoiceService cab = new CabInvoiceService();
		double fare = cab.calculateFare(distance, time);
		System.out.println("The fare calculated is INR " + fare);
		System.out.println("Thanks for visiting!!");
	}
}

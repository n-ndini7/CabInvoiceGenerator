package CabInvoiceGenerator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Assert;

public class CabInvoiceServiceTest {

	@Test
	public void givenDistanceAndTimeShoulReturntheTotalFare() {
		CabInvoiceService cs = new CabInvoiceService();
		double result = cs.calculateFare(5.0, 2.0);
		Assert.assertEquals(52.0, result, 0.0);
	}

	@Test
	public void givenLessDistanceAndTimeShouldReturnMinFare() {
		CabInvoiceService cs = new CabInvoiceService();
		double result = cs.calculateFare(0.1, 1.0);
		Assert.assertEquals(5.0, result, 0.0);

	}

	@Test
	public void givenMultilpleRidesShouldGiveAggregateFare() {
		CabInvoiceService cbs = new CabInvoiceService();
		ArrayList<Ride> rides = new ArrayList<Ride>();
		Ride r1 = new Ride(5.0, 2.0);
		Ride r2 = new Ride(0.1, 1.0);
		rides.add(r1);
		rides.add(r2);
		double res = cbs.calculateFare(rides);
		Assert.assertEquals(57.0, res, 0.0);
	}
}

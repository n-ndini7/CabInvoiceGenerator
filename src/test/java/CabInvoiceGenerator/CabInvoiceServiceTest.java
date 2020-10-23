package CabInvoiceGenerator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;

public class CabInvoiceServiceTest {

	CabInvoiceService cabInvoiceService;

	@Before
	public void setUp() {
		cabInvoiceService = new CabInvoiceService();
	}

	@Test
	public void givenDistanceAndTimeShoulReturntheTotalFare() {
		double result = cabInvoiceService.calculateFare(5.0, 2.0);
		Assert.assertEquals(52.0, result, 0.0);
	}

	@Test
	public void givenLessDistanceAndTimeShouldReturnMinFare() {
		double result = cabInvoiceService.calculateFare(0.1, 1.0);
		Assert.assertEquals(5.0, result, 0.0);

	}

	@Test
	public void givenMultipleRideReturnInvoiceSummary() {
		ArrayList<Ride> rides = new ArrayList<Ride>();
		Ride r1 = new Ride(5.0, 2.0);
		Ride r2 = new Ride(0.1, 1.0);
		rides.add(r1);
		rides.add(r2);
		InvoiceSummary summary = cabInvoiceService.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 57.0);
		Assert.assertEquals(expectedSummary, summary);
	}
}



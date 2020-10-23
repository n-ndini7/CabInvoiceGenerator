package CabInvoiceGenerator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Assert;

public class CabInvoiceServiceTest {

	@Test
	public void givenDistanceAndTimeShoulReturntheTotalFatre() {
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
}

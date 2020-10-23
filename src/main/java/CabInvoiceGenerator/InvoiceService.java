package CabInvoiceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InvoiceService {

	Map<String, ArrayList<Ride>> rideMap;

	public InvoiceService() {
		this.rideMap = new HashMap<>();
	}

	public void addRide(String Id, ArrayList<Ride> rides) {
		if (Id != null)
			rideMap.put(Id, rides);

	}

	public ArrayList<Ride> getRides(String userId) {
		if (rideMap.containsKey(userId))
			return rideMap.get(userId);
		return null;
	}
}

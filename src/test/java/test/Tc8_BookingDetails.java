package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseSJ;
import pages.FlightBookingPagesSJ;
import pages.HomePagesSJ;

public class Tc8_BookingDetails extends BaseSJ{

	@BeforeTest
	public void setup() {
		sheetname = "LocationData";
		testName = "Tc8_BookingDetails";
		testAuthor = "Hariharan";
		testDescription = "Fills out the booking form payment details using dummy data.";
	}
	
	@Test(dataProvider = "readData",priority = 8)
	public void bookingDetails(String SLocation ,String ELoation) {
		HomePagesSJ hpSJ = new HomePagesSJ(driver);
		hpSJ.oneWayTrip(SLocation, ELoation);

		FlightBookingPagesSJ fbSJ = new FlightBookingPagesSJ(driver);
		fbSJ.goToBooking();
		
		fbSJ.bookingDetail("hari", "P", "7871784765", "harifz7581@gmail.com");
		fbSJ.PaymentMethods();
		fbSJ.cardNumber("4111111111111111");
		fbSJ.cardName("hariharan");
		fbSJ.expiryMonth("12");
		fbSJ.expiryYear("2025");
		fbSJ.securCode("458");
		takeScreenshot("Tc8_BookingDetails");
	}
}

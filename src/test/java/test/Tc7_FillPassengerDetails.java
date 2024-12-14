package test;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseSJ;
import pages.FlightBookingPagesSJ;
import pages.HomePagesSJ;

public class Tc7_FillPassengerDetails extends BaseSJ{

	@BeforeTest
	public void setup() {
		sheetname = "LocationData";
		testName = "Tc7_FillPassengerDetails";
		testAuthor = "Hariharan";
		testDescription = "Fills out the booking form with passenger and payment details using dummy data.";
	}
	
	@Test(dataProvider = "readData",priority = 7)
	public void bookingForm(String SLocation ,String ELoation) {
		HomePagesSJ hpSJ = new HomePagesSJ(driver);
		hpSJ.oneWayTrip(SLocation, ELoation);

		FlightBookingPagesSJ fbSJ = new FlightBookingPagesSJ(driver);
		fbSJ.goToBooking();
		fbSJ.bookingDetail("hari", "P", "7871784765", "harifz7581@gmail.com");
		takeScreenshot("Tc7_FillPassengerDetails");
		fbSJ.PaymentMethods();
		Assert.assertEquals(fbSJ.VerifyFillPassergerDetail(), "Payment Methods");
	}
}

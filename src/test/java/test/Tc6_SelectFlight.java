package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseSJ;
import pages.FlightBookingPagesSJ;
import pages.HomePagesSJ;

public class Tc6_SelectFlight extends BaseSJ {

	@BeforeTest
	public void setup() {
		sheetname = "LocationData";
		testName = "Tc6_SelectFlight";
		testAuthor = "Hariharan";
		testDescription = "This test selects a flight from the available options and navigates to the booking page.";
	}
	
	@Test(dataProvider = "readData",priority = 6)
	public void selectFlight(String SLocation ,String ELoation) {
		HomePagesSJ hpSJ = new HomePagesSJ(driver);
		hpSJ.oneWayTrip(SLocation, ELoation);

		FlightBookingPagesSJ fbSJ = new FlightBookingPagesSJ(driver);
		fbSJ.goToBooking();
		Assert.assertEquals(fbSJ.VerifyFlight(), "Contact Details");
		takeScreenshot("Tc6_SelectFlight");
		
	}
}

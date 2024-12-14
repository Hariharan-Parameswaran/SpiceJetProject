package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseSJ;
import pages.HomePagesSJ;

public class Tc5_RoundTrip extends BaseSJ{

	@BeforeTest
	public void setup() {
		sheetname = "LocationData";
		testName = "Tc5_RoundTrip";
		testAuthor = "Hariharan";
		testDescription = "Verify the booking flow for a round trip flight on SpiceJet by entering dummy origin and destination details.";
	}
	
	@Test(dataProvider = "readData",priority = 5)
	public void roundTrip(String SLocation ,String ELoation) {
		HomePagesSJ hpSJ = new HomePagesSJ(driver);
		hpSJ.roundTripDetail(SLocation, ELoation);
		
		Assert.assertEquals(hpSJ.VerifyFlight(), "Flights");
		takeScreenshot("Tc5_RoundTrip");

	}
}

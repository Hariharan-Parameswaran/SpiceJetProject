package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseSJ;
import pages.HomePagesSJ;

public class Tc4_onewayTrip extends BaseSJ{

	@BeforeTest
	public void setup() {
		sheetname = "LocationData";
		testName = "Tc4_onewayTrip";
		testAuthor = "Hariharan";
		testDescription = "Validate the booking process for a one-way flight on SpiceJet by entering dummy origin and destination information.";
	}
	
	@Test(dataProvider = "readData",priority = 4)
	public void oneWaytrip(String SLocation ,String ELoation) {
		HomePagesSJ hpSJ = new HomePagesSJ(driver);
		hpSJ.oneWayTrip(SLocation, ELoation);
		
		Assert.assertEquals(hpSJ.VerifyFlight(), "Flights");
		
		takeScreenshot("Tc4_oneWayTrip");
	}
}

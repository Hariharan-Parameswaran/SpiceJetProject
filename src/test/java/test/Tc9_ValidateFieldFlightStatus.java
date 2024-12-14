package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseSJ;
import pages.HomePagesSJ;

public class Tc9_ValidateFieldFlightStatus extends BaseSJ {

	@BeforeTest
	public void setup() {
		sheetname = "LocationData";
		testName = "Tc9_ValidateFieldFlightStatus";
		testAuthor = "Hariharan";
		testDescription = "Validate the Flight Status field functionality on the SpiceJet booking page.";
	}

	@Test(dataProvider = "readData",priority = 10)
	public void checkFlightStatus(String SLocation, String ELoation) {
		HomePagesSJ hpSJ = new HomePagesSJ(driver);
		hpSJ.goToFlightStatus(SLocation, ELoation);
		Assert.assertEquals(hpSJ.VerifyFlight(), "Flights");

		takeScreenshot("Tc9_ValidateFieldFlightStatus");
	}
}

package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseSJ;
import pages.HomePagesSJ;

public class Tc9_ValidateFieldManageBooking extends BaseSJ {

	@BeforeTest
	public void setup() {
		sheetname = "CheckInAndManageData";
		testName = "Tc9_ValidateFieldManageBooking";
		testAuthor = "Hariharan";
		testDescription = "Validate the Manage Booking field functionality on the SpiceJet booking page.";
	}
	
	@Test(dataProvider = "readData",priority = 11)
	public void managebooking(String PRNumber,String Email) {
		HomePagesSJ hpSJ = new HomePagesSJ(driver);
		hpSJ.goToManageBooking(PRNumber, Email);
		String actualTitle = driver.getTitle();
		String expectedTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		Assert.assertEquals(expectedTitle, actualTitle);
		takeScreenshot("Tc9_ValidateFieldManageBooking");
	}
}

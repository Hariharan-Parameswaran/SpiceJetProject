package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseSJ;
import pages.HomePagesSJ;

public class Tc9_ValidateFieldCheckIn extends BaseSJ{

	@BeforeTest
	public void setup() {
		sheetname = "CheckInAndManageData";
		testName = "Tc9_ValidateFieldCheckIn";
		testAuthor = "Hariharan";
		testDescription = "Validate the check-in field functionality on the SpiceJet booking page.";
	}
	
	@Test(dataProvider = "readData",priority = 9)
	public void validateField(String PRNumber,String Email) {
		HomePagesSJ hpSJ = new HomePagesSJ(driver);
		hpSJ.goToCheckIn(PRNumber, Email);
		String actualTitle = driver.getTitle();
		String expectedTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		Assert.assertEquals(expectedTitle, actualTitle);
		takeScreenshot("Tc9_ValidateFieldCheckIn");
	}
}

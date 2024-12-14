package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseSJ;

public class Tc1_navigatetowebsite extends BaseSJ {

	@BeforeTest
	public void setup() {
		testName = "Tc1_navigatetowebsite ";
		testAuthor = "Hariharan";
		testDescription = "Navigating to the SpiceJet e-commerce website";
	}
	@Test(priority = 1)
	public void navigateToWebSite() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		Assert.assertEquals(expectedTitle, actualTitle);
		takeScreenshot("Tc1_navigatetowebsite");
	}
}

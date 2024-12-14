package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseSJ;
import pages.HomePagesSJ;
import pages.LoginPagesSJ;

public class Tc3_LoginSJ extends BaseSJ {

	@BeforeTest
	public void setup() {
		sheetname = "LoginData";
		testName = "Tc3_LoginSJ";
		testAuthor = "Hariharan";
		testDescription = "Login Functionality";
	}

	@Test(dataProvider = "readData",priority = 3)
	public void navigateLoginDetail(String email, String psword) {
		HomePagesSJ hpSJ = new HomePagesSJ(driver);
		hpSJ.goToLogin();

		LoginPagesSJ lpSJ = new LoginPagesSJ(driver);
		lpSJ.loginDetails(email, psword);

		String actualTitle = driver.getTitle();
		String expectedTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		Assert.assertEquals(expectedTitle, actualTitle);
		takeScreenshot("Tc3_LoginSJ");

	}
}

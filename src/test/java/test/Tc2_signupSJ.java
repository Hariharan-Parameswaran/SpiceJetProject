package test;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseSJ;
import pages.HomePagesSJ;
import pages.SignUpPagesSJ;

public class Tc2_signupSJ extends BaseSJ {

	@BeforeTest
	public void setup() {
		sheetname = "SignInData";
		testName = "Tc2_signupSJ";
		testAuthor = "Hariharan";
		testDescription = "SignUp Functionality";
	}

	@Test(dataProvider = "readData",priority = 2)
	public void signupSJ(String fname, String lname, String Dob, String phoneNumber, String email, String password,
			String confirmPassord) {
		try {
			HomePagesSJ hpSJ = new HomePagesSJ(driver);
			hpSJ.goToSignUp();

			Set<String> windowHandles = driver.getWindowHandles();
			Iterator<String> iterator = windowHandles.iterator();

			String parentWindow = iterator.next();
			String signUpWindow = iterator.next();

			driver.switchTo().window(signUpWindow);

			SignUpPagesSJ spSJ = new SignUpPagesSJ(driver);
			spSJ.signuoDetails(fname, lname, Dob, phoneNumber, email, password, confirmPassord);
			takeScreenshot("Tc2_signupSJ");

			driver.switchTo().window(parentWindow);
		} catch (Exception e) {
			takeScreenshot("Tc2_signupSJfc");
			e.printStackTrace();
		}

	}

}

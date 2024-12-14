package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseSJ;

public class SignUpPagesSJ extends BaseSJ {

	@FindBy(xpath = "//select[@class='form-control form-select ']")
	WebElement selectTitle;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement fname;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lname;

	@FindBy(xpath = "//input[@id='dobDate']")
	WebElement dobDate;

	@FindBy(xpath = "//input[@placeholder='+91 01234 56789']")
	WebElement mobnumber;

	@FindBy(id = "email_id")
	WebElement email;

	@FindBy(xpath = "//input[@id='new-password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='c-password']")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@id='defaultCheck1']")
	WebElement checkbox;

	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submitButton;

	@FindBy(xpath = "//label[text()='OTP Verification']")
	WebElement signText;

	WebDriver driver;

	public SignUpPagesSJ(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void signuoDetails(String name, String lastName, String DOB, String phNumber, String emaddress, String pswd,
			String cpswd) {

		Select titleDropdown = new Select(selectTitle);
		titleDropdown.selectByVisibleText("Mr");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(fname));
		fname.sendKeys(name);

		wait.until(ExpectedConditions.visibilityOf(lname));
		lname.sendKeys(lastName);

		wait.until(ExpectedConditions.visibilityOf(dobDate));
		dobDate.sendKeys(DOB);

		wait.until(ExpectedConditions.visibilityOf(mobnumber));
		mobnumber.sendKeys(phNumber);

		wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(emaddress);

		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pswd);

		wait.until(ExpectedConditions.visibilityOf(confirmPassword));
		confirmPassword.sendKeys(cpswd);

		wait.until(ExpectedConditions.visibilityOf(checkbox));
		checkbox.click();

		wait.until(ExpectedConditions.visibilityOf(submitButton));
		submitButton.click();
	}

	public void submitDetail() {
		submitButton.click();
	}

	public void signInText() {
		signText.getText();
	}
}

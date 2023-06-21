package mindq.cucumberframeworkApril2023.pageobjects;


import org.openqa.selenium.By;

import mindq.cucumberframeworkApril2023.base.Base;



public class LoginPage extends Base {

	public static By emailInputBox = By.id("user_email");
	public static By passwordInputBox = By.id("user_password");
	public static By signInButton = By.name("commit");
	public static By allProjectsText = By.id("ember67");
	public static By errorMessage = By.tagName("h2");

	public static void enterEmailId(String emailid) {

		try {
			driver.findElement(emailInputBox).clear();
			driver.findElement(emailInputBox).sendKeys(emailid);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void enterPassword(String password) {

		try {
			driver.findElement(passwordInputBox).clear();
			driver.findElement(passwordInputBox).sendKeys(password);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void clickSignInButton() {

		try {
			driver.findElement(signInButton).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String captureAllProjectsText() {

		String text = driver.findElement(allProjectsText).getText();
		return text;
	}

	public static String captureErrorText() {

		String text = driver.findElement(errorMessage).getText();
		return text;
	}

}

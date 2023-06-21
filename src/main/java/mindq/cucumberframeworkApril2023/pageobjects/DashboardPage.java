package mindq.cucumberframeworkApril2023.pageobjects;

import org.openqa.selenium.By;

import mindq.cucumberframeworkApril2023.base.Base;

public class DashboardPage extends Base {

	public static By profileButton = By.xpath("//img[@class='img-circle avatar-icon']");
	public static By signOutButton = By.xpath("//a[text()='Sign out']");
	public static By welcomeBackText = By.xpath("//h1[@class='landing-section-title']");

	public static void clickProfileButton() {
		driver.findElement(profileButton).click();
	}

	public static void clicksignOutButton() {
		driver.findElement(signOutButton).click();
	}
	
	
	public static String captureWelcomeBackText() {
		
		String text = driver.findElement(welcomeBackText).getText();
		return text;
	}


}

package mindq.cucumberframeworkApril2023.stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Step;
import io.cucumber.messages.types.TestStep;
import io.cucumber.messages.types.TestStepFinished;
import mindq.cucumberframeworkApril2023.base.Base;
import mindq.cucumberframeworkApril2023.pageobjects.LoginPage;
import tech.grasshopper.reporter.ExtentExcelCucumberReporter;

public class LoginStepDefinitions extends LoginPage {
	
	static Logger log = Logger.getLogger(LoginStepDefinitions.class);

	//@Given("^I am in login page$")
	@Before
	public static void userisinLogin() {
		launchBrowser("Chrome");
		launchApplication("https://studio.cucumber.io/users/sign_in");
		implicitWait(5);
		System.out.println("Before every scenario");
	}
	@After
	public static void tearDown(Scenario scenario) throws IOException {
	 
		
	        //validate if scenario has failed
	        if(scenario.isFailed()) {
	        	
	    		ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Test is failed");

	            final byte[] screenshot = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.BYTES);
	           scenario.attach(screenshot, "image/png", scenario.getName());
	            //scenario.attach(captureScreenshot(),"image/png", scenario.getName());
	       }  
	}
	//@After
	public static void close() {
		closeBrowser();
		System.out.println("browser closed after every scenario");
	}

	@When("I enter email id {string}")
	public void i_enter_email_id(String email) {
		
		
		
		enterEmailId(email);
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "User entered email id");
		log.info("Entered email id "+email);
	   
	}

	@When("I enter password {string}")
	public void i_enter_password(String password) {
		enterPassword(password);
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "User entered password");
		log.info("Entered password "+password);
	}
	
	
	@And("^I click sign in button$")
	public static void i_click_signin_button() {

		clickSignInButton();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "User clicked sign in");
		log.info("clicked sign in button");

	}

	@Then("^I should be able to see the All projects page$")
	public static void i_should_see_allprojects() throws IOException {

		String actualValue = captureAllProjectsText();

		String expectedValue = "All projectS";

		Assert.assertEquals(actualValue, expectedValue);
		
		
		
	}
	
	@Then("I should see error message on the screen")
	public void i_should_see_error_message_on_the_screen() {
	   
		String actualValue = captureErrorText();
		String expectedValue = "An error has occurred";

		Assert.assertEquals(actualValue, expectedValue);
		
	}


}

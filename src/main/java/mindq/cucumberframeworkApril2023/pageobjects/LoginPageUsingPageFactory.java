package mindq.cucumberframeworkApril2023.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mindq.cucumberframeworkApril2023.base.Base;

public class LoginPageUsingPageFactory extends Base{
	
	@FindBy(id="user_email")
	public static WebElement emailInputBox;
	
	@FindBy(id="user_password")
	public static WebElement passwordInputBox;
	
	@FindBy(name="commit")
	public static WebElement signInButton;
	
	@FindBy(id="ember67")
	public static WebElement allProjectsText;
	
	
    public LoginPageUsingPageFactory(WebDriver driver) {
    	
    	Base.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    
    
    public  void enterEmailId(String emailid) {

		try {
			emailInputBox.sendKeys(emailid);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public  void enterPassword(String password) {

		try {
			passwordInputBox.sendKeys(password);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public  void clickSignInButton() {
		
		try {
			signInButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public  String captureAllProjectsText() {
		
		
		String text = allProjectsText.getText();
		return text;
	}
	

}

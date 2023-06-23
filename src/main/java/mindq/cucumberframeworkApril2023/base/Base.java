package mindq.cucumberframeworkApril2023.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;

	// This method will launch the browser based on the parameter "browser"

	public static void launchBrowser(String browser) {

		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		} else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();

			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(options);
		} else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			// options.addArguments("--remote-allow-origins=*");
			driver = new FirefoxDriver(options);
		}

		driver.manage().window().maximize();

	}
	
	 @Parameters("browser")
	   @BeforeTest
	public static void launchAppUsingRemote(String browser) throws MalformedURLException {
		 String URL = "http://www.calculator.net";
	      
	      if (browser.equalsIgnoreCase("firefox")) {
	         System.out.println(" Executing on FireFox");
	         String Node = "http://10.112.66.52:5555/wd/hub";
	      FirefoxOptions options = new FirefoxOptions();
				
				options.setCapability("browser", "firefox");
	         
	         driver = new RemoteWebDriver(new URL(Node), options);
	         implicitWait(5);
	         driver.navigate().to(URL);
	         driver.manage().window().maximize();
	      } else if (browser.equalsIgnoreCase("chrome")) {
	         System.out.println(" Executing on CHROME");
	         ChromeOptions options = new ChromeOptions();
	         options.setCapability("browser", "chrome");
	         String Node = "http://10.112.66.52:5557/wd/hub";
	         driver = new RemoteWebDriver(new URL(Node), options);
	         implicitWait(5);
	      }else if (browser.equalsIgnoreCase("ie")) {
	          System.out.println(" Executing on IE");
	          InternetExplorerOptions options = new InternetExplorerOptions();
		         options.setCapability("browser", "InternetExplorer");
	          String Node = "http://10.112.66.52:5558/wd/hub";
	          driver = new RemoteWebDriver(new URL(Node), options);
	          implicitWait(5);
	          driver.navigate().to(URL);
	          driver.manage().window().maximize();
	       } else {
	          throw new IllegalArgumentException("The Browser Type is Undefined");
	       }
	}

	// This method will launch the application based on the parameter "url"
	public static void launchApplication(String url) {

		driver.get(url);

	}

	public static void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public static void closeBrowser() {

		driver.close();
	}

	public static String captureScreenshot() throws IOException {

		// Convert webdriver object to TakeScreenshot

		TakesScreenshot scrShot = (TakesScreenshot) driver;

		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);

		File destinationPath = new File(
				"C://Users//PRASHANTHI//eclipse-workspace//MindQWorkSpace//cucumberframeworkApril2023//Screenshots//"
						+ "ScreenCapture" + System.currentTimeMillis() + ".png");

		FileUtils.copyFile(scrFile, destinationPath);

		String filePath = destinationPath.getAbsolutePath();

		return filePath;

	}

}

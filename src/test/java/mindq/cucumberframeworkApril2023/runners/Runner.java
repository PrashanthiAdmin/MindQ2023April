package mindq.cucumberframeworkApril2023.runners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import mindq.cucumberframeworkApril2023.base.Base;




@CucumberOptions(features = {"Features"},
                 glue = {"mindq.cucumberframeworkApril2023.stepdefinitions"},
                 plugin = {"pretty","html:target/cucumber-reports/cucumberreport.html"
                		 ,"json:target/cucumber-reports/Cucumber.json",
                		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                 tags= "@validlogin",
                 monochrome = true)
public class Runner extends AbstractTestNGCucumberTests{



}

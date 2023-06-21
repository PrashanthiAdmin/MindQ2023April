

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;




@CucumberOptions(features = {"Features" },
                 glue =     {"mindq.cucumberframeworkApril2023.stepdefinitions"},
                	plugin = { "pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                 tags =     "@validlogin",
                 monochrome = true)
public class Runner extends AbstractTestNGCucumberTests{


	

	 
}


package com_Runner;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com_DriverFactory.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resource/com_features",
		glue={"com_Steps","com_Hooks"},
		monochrome = false,
		plugin = {
				"pretty",
				"html:target/cucumber-report.html",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		}
		
		)


public class Test_Runner extends AbstractTestNGCucumberTests {
	

//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios(){
//		return super.scenarios();
//	}
	
	@BeforeMethod
	@Parameters("browser")
	public void setBrowser(String browser) {
		DriverFactory.setBrowser(browser);
	}
//	
	
}

//allure serve allure-results
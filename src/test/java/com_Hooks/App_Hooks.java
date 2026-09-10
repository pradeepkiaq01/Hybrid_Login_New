package com_Hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com_DriverFactory.DriverFactory;
import com_Utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class App_Hooks {
	
	private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;
    
    @Before(order =0)
    public void getProperty() {
            configReader =new ConfigReader();
            prop=configReader.init_prop();        
    }
    @Before(order=1)
   // @Parameters("browser")
    public void launchBrowser() {
    	   String browsername=DriverFactory.getBrowser();
            System.out.println("Browser name:"+browsername);
            driverFactory = new DriverFactory();
            driver= driverFactory.init_driver(browsername);
            DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
    }

    @After(order=1)
    public void quitBrowser() {
            driverFactory.quitDriver();
    }
    @After(order=0)
    public void tearDown(Scenario sc) {
            if(sc.isFailed()) {
                    String screenshotname=sc.getName().replaceAll("", "_");
                    byte [] sourcePath=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    sc.attach(sourcePath, "image/png", screenshotname);
            }
          }
    }

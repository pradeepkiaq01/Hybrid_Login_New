package com_DriverFactory;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
  public WebDriver driver;
  public static ThreadLocal<WebDriver> tld=new ThreadLocal<>();
  public static ThreadLocal<String> browserThread=new ThreadLocal<>();
  
  
  public WebDriver init_driver(String browser) {
	  System.out.println("Browser value is :"+browser);
	  
	  if(browser.equals("chrome")) {
		  ChromeOptions op= new ChromeOptions();
			 Map<String,Object> prefs=new HashMap<>();
			 prefs.put("credentials_enable_service", false);
			 prefs.put("profile.password_manager_enabled", false);
			 prefs.put("profile.password_manager_leak_detection", false);
			 
			 op.setExperimentalOption("prefs", prefs);
			 op.addArguments("--disable-notifications");
			 op.addArguments("--disable-popup-notifications");
			 
			 WebDriverManager.chromedriver().setup();
			 tld.set(new ChromeDriver());
	  }
	  else if(browser.equals("firefox")) {
		  WebDriverManager.firefoxdriver().setup();
		  tld.set(new FirefoxDriver());
	  }
	  else if (browser.equals("edge")) {
		  WebDriverManager.edgedriver().setup();
		  tld.set(new EdgeDriver());
	  }
	  else {
		  System.out.println("please pass the correct browser value :"+browser);
	  }
	  getDriver().manage().deleteAllCookies();
	  getDriver().manage().window().maximize();
	  
	 
		 
	 return getDriver(); 
	  
	  
	  
  }
  public static synchronized WebDriver getDriver() {
	  return tld.get();
  }
  
  public static void quitDriver() {
	  if (tld.get() != null) {
		  tld.get().quit();
		  tld.remove();
	  }
  }
  
  public static void setBrowser(String browser) {
	  browserThread.set(browser);
  }
  
  public static String getBrowser() {
	  return browserThread.get();
  }
  
  
  
}

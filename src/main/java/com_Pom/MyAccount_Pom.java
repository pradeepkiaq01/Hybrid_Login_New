package com_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_Utils.ElementUtils;

public class MyAccount_Pom {

	private final WebDriver driver;
	private ElementUtils el;
	
	public MyAccount_Pom(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		el=new ElementUtils(driver);
		//hp=new HomePage_Pom(driver);
	}
   
	@FindBy(xpath="//h2[text()='My Account']")private WebElement MyAcc;
	@FindBy(xpath="//a[text()='Change your password']")private WebElement change;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement success;
	@FindBy(xpath="//a[text()='Logout']")private WebElement Logout;
	@FindBy(xpath="//a[text()='Continue']")private WebElement contue;
	
	
	
	
	public String getTextMyAcc() {
			return el.getText(MyAcc);
	}
	public void clickChange() {
		el.Click(change);
	}
	public boolean isSuccessDisplayed() {
		return el.isDisplayed(success);	
	}
	public void clickLogout() {
		el.Click(Logout);
	}
	public void clickContinue() {
		el.Click(contue);
	}
	
	
}

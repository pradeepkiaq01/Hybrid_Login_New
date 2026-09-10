package com_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_Utils.ElementUtils;

public class HomePage_Pom {
	private final WebDriver driver;
	private ElementUtils el;
	
	public HomePage_Pom(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		el=new ElementUtils(driver);
	}

	@FindBy(xpath="//a[@title='My Account']")public WebElement my_Acnt;
	@FindBy(xpath="//a[@title='My Account']//following::a[text()='Login']")public WebElement login;
	@FindBy(xpath="//a[text()='Order History']")public WebElement oderhis;
	//@FindBy(xpath="")public WebElement ;
	//@FindBy(xpath="")public WebElement ;
	//@FindBy(xpath="")public WebElement ;
	//@FindBy(xpath="")public WebElement ;
    //@FindBy(xpath="")public WebElement ;
	//@FindBy(xpath="")public WebElement ;
	//@FindBy(xpath="")public WebElement ;
	//@FindBy(xpath="")public WebElement ;	
	
	public String  getTitleHp() {
		return el.getTittle();
	}
	public String getTitleLp() {
		return el.getTittle();
	}
	public void clickMyacnt() {
		el.Click(my_Acnt);
	}
	public void clickLogin() {
		el.Click(login);
	}
	
	public void navigateToLogin() {
		el.Click(my_Acnt);
		el.Click(login);
	}
	public boolean orderHistoryDis() {
		return el.isDisplayed(oderhis);
	}
	
}
package com_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_Utils.ElementUtils;

public class ChangePwdPage_Pom {
	
private final WebDriver driver;
private ElementUtils el;
		
	public ChangePwdPage_Pom(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
			el=new ElementUtils(driver);
			//hp=new HomePage_Pom(driver);
		}
	   
	@FindBy(xpath="//input[@id='input-confirm']")private WebElement cnf_pwd;
    @FindBy(xpath="//input[@id='input-password']")private WebElement pwd;
    @FindBy(xpath="//input[@value='Continue']")private WebElement cntune;
    //@FindBy(xpath="")private WebElement ;
    //@FindBy(xpath="")private WebElement ;
    //@FindBy(xpath="")private WebElement ;
    
    
    
	public void sendPassword(String s) {
		el.sendKeys(pwd, s);
	}
	public void sendcnfPassword(String s) {
		el.sendKeys(cnf_pwd, s);
	}
	public void clickContinue() {
		el.Click(cntune);
	}
	

}

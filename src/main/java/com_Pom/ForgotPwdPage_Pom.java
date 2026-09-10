package com_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_Utils.ElementUtils;

public class ForgotPwdPage_Pom {
	
	private final WebDriver driver;
	private ElementUtils el;
	
	public ForgotPwdPage_Pom (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		el=new ElementUtils(driver);
		
	}

	@FindBy(xpath="//h1[text()='Forgot Your Password?']")private WebElement frgt_text;
	@FindBy(xpath="//input[@id='input-email']")public WebElement Ent_email;
    @FindBy(xpath="//input[@value='Continue']")public WebElement cont_btn;
	@FindBy(xpath="//ul[@class='breadcrumb']//following::div[@class='alert alert-success alert-dismissible']")public WebElement ss_msg;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")public WebElement Err_msg;
	@FindBy(xpath="//a[text()='Forgotten Password']")public WebElement column;
	
	public void clickContinue() {
		el.Click(cont_btn);
	}
	public String getTextFrgt() {
		return el.getText(frgt_text);
	}
	public boolean isErrorDis() {
		return el.isDisplayed(Err_msg);
	}
	public boolean isSucDis() {
		return el.isDisplayed(ss_msg);
	}
	public void EnterEmail(String s) {
		el.sendKeys(Ent_email, s);
	}
	public String emailValue() {
		return el.getAttribute(Ent_email, "value");
	}
	////
	
	public String placeHolder() {
		return el.getAttribute(Ent_email, "placeholder");
	}
	public void clickColumn() {
		el.Click(column);
	}
	public boolean isFGTpwd_dis() {
		return el.isDisplayed(frgt_text);
	}
	
  
}

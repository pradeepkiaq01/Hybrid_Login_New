package com_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com_Utils.ElementUtils;

public class LoginPage_Pom {
	private final WebDriver driver;
	private ElementUtils el;
	private MyAccount_Pom ma;
	//private ChangePwdPage_Pom cp;
	public LoginPage_Pom(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		el=new ElementUtils(driver);
		ma=new MyAccount_Pom(driver);
		//cp=new ChangePwdPage_Pom(driver);
	}
   
	@FindBy(xpath="//a[text()='Forgotten Password']")private WebElement frg_pwd;
	@FindBy(xpath="//input[@id='input-email']")private WebElement ent_mail;
	@FindBy(xpath="//input[@id='input-password']")private WebElement ent_pwd;
	@FindBy(xpath="//input[@value='Login']")private WebElement login_btn;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement Error;
	@FindBy(xpath="//a[text()='Continue']")private WebElement clk_con;
	@FindBy(xpath="(//a[text()='Forgotten Password'])[2]")private WebElement Right_fgp;
	@FindBy(xpath="(//a[text()='Register'])[2]")private WebElement right_Reg;
	@FindBy(xpath="//ul[@class='breadcrumb']")private WebElement breadcrump;
	@FindBy(xpath="//a[text()='Qafox.com']")private WebElement header;
	
	public void enterMail(String email) {
		el.sendKeys(ent_mail, email);
	}
	public void enterPwd(String pwd) {
		el.sendKeys(ent_pwd, pwd);
	}
	public void clickLogin() {
		el.Click(login_btn);
	}
	public boolean ErrorDis() {
		return el.isDisplayed(Error);
	}
	
	public void clickFrgt_pwd() {
		el.Click(frg_pwd);
	}
	
	public String getAttributeEmail() {
		return el.getAttribute(ent_mail, "value");
	}
	public String getAttributepwd() {
		return el.getAttribute(ent_pwd, "value");
	}
	public String getplaceholderEmail() {
		return el.getAttribute(ent_mail, "placeholder");
	}
	public String getplaceholderpwd() {
		return el.getAttribute(ent_pwd, "placeholder");
	}
	public boolean isFrgtPwd_dis() {
		return el.isDisplayed(frg_pwd);
	}
	public void validation(String result) {
		if(result.equalsIgnoreCase("Invalid")) {
			 Assert.assertTrue(ErrorDis());
		}
		else if(result.equalsIgnoreCase("My Account")) {
		 Assert.assertEquals(ma.getTextMyAcc(), "My Account");
		}
	}
	public void focusEmail() {
		el.pressTabFocused(ent_mail);
	}
	public void focusPwd() {
		el.pressTabFocused(ent_pwd);
	}
	public void focusLogin() {
		el.pressTabFocused(login_btn);
	}
	public void EnterLogin() {
		el.pressEnter();
	}
	public void clickloginFive() {
		for (int i = 0; i <= 5; i++) {
			clickLogin();
		}
	}
	public void naviBack() {
		el.navigateBack();
	}
	
	public String getPassType() {
		return el.getAttribute(ent_pwd, "type");
	}
	public void clsBrowser() {
		el.closeBrowser();
	}
	
	public void clickContinue() {
		el.Click(clk_con);
	}
	
	public void clickReg() {
		el.Click(right_Reg);
	}
	public void ClickFgp() {
		el.Click(Right_fgp);
	}
	
	public String getTitle_Login() {
		return el.getTittle();
	}
	public String getCurrentUrl_Login() {
		return el.getCurrentUrl();
	}
	public boolean isBreadCrumpDis() {
		return el.isDisplayed(breadcrump);
	}
	public String getTextHeader() {
		return el.getText(header);
	}
}

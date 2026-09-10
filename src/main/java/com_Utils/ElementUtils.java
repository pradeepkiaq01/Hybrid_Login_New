package com_Utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	private final WebDriver driver;
	private final WebDriverWait wait;
	
	public ElementUtils (WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(ConstantUtils.EXPLICIT_WAIT_TIME));
	}
	
	//click
	public void Click(WebElement e) {
		wait.until(ExpectedConditions.elementToBeClickable(e));
		e.click();
	}
	
	//Wait
	public WebElement waitForVisibility(WebElement e) {
		return wait.until(ExpectedConditions.visibilityOf(e));
	}

	public List<WebElement> waitForVisibilityOfAllelemens(List<WebElement> e) {
		return wait.until(ExpectedConditions.visibilityOfAllElements(e));
	}

	public Alert waitForalertisPresent() {
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	public WebElement waitForClick(WebElement e) {
		return wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	//sendKeys
		public void sendKeys(WebElement e, String v) {
			WebElement we =  waitForVisibility(e);
			we.click();
			we.clear();
			we.sendKeys(v);
		}
	//getText
	public String getText(WebElement e) {
		WebElement we=waitForVisibility(e);
		return we.getText();
	}
	//getAttribute
	public String getAttribute(WebElement e,String attributename) {
		WebElement we=waitForVisibility(e);
		return we.getAttribute(attributename);

	}
	//getTitle
	public String getTittle() {
	 		return driver.getTitle();
		}
	//GetCuurentUrl
	public String getCurrentUrl() {
			 return driver.getCurrentUrl();
		}
	//selectByValue
	public void selectByvalue(WebElement e,String v) {
		WebElement we=waitForVisibility(e);
		Select select=new Select(we);
		select.selectByValue(v);
	}
	//selectByIndex
	public void selectByIntex(WebElement e, int  i) {
		WebElement we=waitForVisibility(e);
		Select select=new Select(we);
		select.selectByIndex(i);
	}
	//selectByText
	public void selectByText(WebElement e,String v) {
		WebElement we=waitForVisibility(e);
		Select select=new Select(we);
		select.selectByVisibleText(v);
	}
	
	//JsClick
	public void jsclick(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",e);
	}
	
	//jsScroll
	public void  scrollToElement(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollintoView({block:'center'});",e);
	}
	
	//isDisplayed
	public boolean isDisplayed(WebElement e) {
		WebElement we=waitForVisibility(e);
		return we.isDisplayed();
	}
	// isEnabled
    public boolean isEnabled(WebElement e) {
    	WebElement we=waitForVisibility(e);
            return we.isEnabled();

    }
    // isSelected
    public boolean isSelected(WebElement e) {
    	WebElement we=waitForVisibility(e);
            return we.isSelected();

    }

	//press tab until focus
    public void pressTabFocused(WebElement e) {
    	WebElement expected= e;
    	for(int i=0;i<25;i++) {
    		WebElement activeEl=driver.switchTo().activeElement();
    		if(activeEl.equals(expected)) {
    			return;
    		}
    		activeEl.sendKeys(Keys.TAB);
    	}
    	throw new RuntimeException("Element didnt receive focus");
    }

    //press enter
    public void pressEnter() {
    	driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }
	
	//navigateBack
    public void navigateBack() {
    	driver.navigate().back();
    }
	//driverclose
    public void closeBrowser() {
    	driver.close();
    }
	
	
	
	
	
	
	
	

}

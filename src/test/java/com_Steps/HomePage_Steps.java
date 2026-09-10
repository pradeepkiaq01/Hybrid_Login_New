package com_Steps;

import org.testng.Assert;

import com_DriverFactory.DriverFactory;
import com_Pom.HomePage_Pom;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage_Steps {
   HomePage_Pom hp=new HomePage_Pom(DriverFactory.getDriver());
   
   @Given("user open url of the application")
   public void user_open_url_of_the_application() {
       
   }

   @Then("validate the Url of the application {string}")
   public void validate_the_url_of_the_application(String string) {
       Assert.assertTrue(hp.getTitleHp().contains(string));
   }

   @When("user click on myAccount")
   public void user_click_on_my_account() {
       hp.clickMyacnt();
   }

   @When("user click on Login in dd")
   public void user_click_on_login_in_dd() {
      hp.clickLogin();
   }

   @Then("Validate user is on Login Page {string}")
   public void validate_user_is_on_login_page(String string) {
       Assert.assertTrue(hp.getTitleLp().contains(string));
   }
	
}

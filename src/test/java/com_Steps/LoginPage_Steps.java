package com_Steps;

import org.testng.Assert;

import com_DriverFactory.DriverFactory;
import com_Pom.ChangePwdPage_Pom;
import com_Pom.ForgotPwdPage_Pom;
import com_Pom.HomePage_Pom;
import com_Pom.LoginPage_Pom;
import com_Pom.MyAccount_Pom;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage_Steps {
	
	HomePage_Pom hp=new HomePage_Pom(DriverFactory.getDriver());
    LoginPage_Pom lp =new LoginPage_Pom(DriverFactory.getDriver());
    ForgotPwdPage_Pom fp= new ForgotPwdPage_Pom(DriverFactory.getDriver());;
    MyAccount_Pom mp=new MyAccount_Pom(DriverFactory.getDriver());;
    ChangePwdPage_Pom cp=new ChangePwdPage_Pom(DriverFactory.getDriver());;
    
    @When("user enters Email filed {string}")
    public void user_enters_email_filed(String email) {
        lp.enterMail(email);
        Assert.assertEquals(lp.getAttributeEmail(), email);
    }

    @When("user enters password in field {string}")
    public void user_enters_password_in_field(String password) {
        lp.enterPwd(password);
        Assert.assertEquals(lp.getAttributepwd(), password);
    }

    @When("user click Login button")
    public void user_click_login_button() {
        lp.clickLogin();
    }

    @Then("validate with result {string}")
    public void validate_with_result(String results) {
       lp.validation(results);
    }

    @Then("validate {string} is present")
    public void validate_is_present(String text) {
        Assert.assertTrue(lp.isFrgtPwd_dis());
    }

    @When("user click on forgot password")
    public void user_click_on_forgot_password() {
       lp.clickFrgt_pwd();
    }

    @Then("validate user is on {string} page")
    public void validate_user_is_on_page(String header) {
    	System.out.println(fp.getTextFrgt());
        Assert.assertTrue(fp.getTextFrgt().contains(header));
    }
    
    //7
    @When("user press tab key until the email field focused")
    public void user_press_tab_key_until_the_email_field_focused() {
        lp.focusEmail();
    }

    @When("user press tab key untill it focus password")
    public void user_press_tab_key_untill_it_focus_password() {
       lp.focusPwd();
    }

    @When("user press tab key until the login button focus")
    public void user_press_tab_key_until_the_login_button_focus() {
        lp.focusLogin();
    }

    @When("user press enter key")
    public void user_press_enter_key() {
       lp.EnterLogin();
    }

    //8
    @Then("user should see correct placholder text in email box {string}")
    public void user_should_see_correct_placholder_text_in_email_box(String EmailAtt) {
        Assert.assertEquals(lp.getplaceholderEmail(), EmailAtt);
    }

    @Then("user should see correct placholder text in password box {string}")
    public void user_should_see_correct_placholder_text_in_password_box(String passwordAtt) {
        Assert.assertEquals(lp.getplaceholderpwd(), passwordAtt);
    }
    //9
    @When("user click on back button")
    public void user_click_on_back_button() {
       lp.naviBack();
    }

    //12
    @When("user click Login button five times")
    public void user_click_login_button_five_times() {
        lp.clickloginFive();
    }
    
    @Then("validate password filed is should be hide {string}")
    public void validate_password_filed_is_should_be_hide(String type) {
        Assert.assertEquals(lp.getPassType(), type);
    }

    @When("user click change password")
    public void user_click_change_password() {
       mp.clickChange();
    }

    @When("enter {string} and confirm {string}")
    public void enter_and_confirm(String password, String cnfpassword) {
        cp.sendPassword(password);
        cp.sendcnfPassword(cnfpassword);
    }
    @When("click continue button on cho page")
    public void click_continue_button_on_cho_page() {
        cp.clickContinue();
    }

    @Then("validate successfully changed")
    public void validate_successfully_changed() {
       Assert.assertTrue(mp.isSuccessDisplayed());
    }

    @When("user click on logout")
    public void user_click_on_logout() {
        mp.clickLogout();
    }

    @When("click continue button")
    public void click_continue_button() {
        mp.clickContinue();
    }

    @When("user close the browser")
    public void user_close_the_browser() {
        lp.clsBrowser();
    }

    @Then("user remain looged in")
    public void user_remain_looged_in() {
       Assert.assertTrue(hp.orderHistoryDis());
    }
    
    //
    
    @When("user click on continue button on new user")
    public void user_click_on_continue_button_on_new_user() {
       lp.clickContinue();
    }
//
    @When("user click on Register accnt")
    public void user_click_on_register_accnt() {
        lp.clickReg();
    }

    @When("user click on forgot password from right column")
    public void user_click_on_forgot_password_from_right_column() {
        lp.ClickFgp();
    }
    
//
    @Then("user validate breadcrump is displayed")
    public void user_validate_breadcrump_is_displayed() {
        Assert.assertTrue(lp.isBreadCrumpDis());
    }

    @Then("user validate title of login page {string}")
    public void user_validate_title_of_login_page(String title) {
       Assert.assertEquals(lp.getTitle_Login(), title);
    }

    @Then("user validate url of the login page {string}")
    public void user_validate_url_of_the_login_page(String Url) {
       Assert.assertEquals(lp.getCurrentUrl_Login(), Url);
    }

    @Then("user validate header on login page {string}")
    public void user_validate_header_on_login_page(String Header) {
       Assert.assertEquals(lp.getTextHeader(), Header);
    }
    
}

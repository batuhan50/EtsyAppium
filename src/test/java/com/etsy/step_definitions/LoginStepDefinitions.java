package com.etsy.step_definitions;

import com.etsy.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepDefinitions {



    LoginPage loginPage = new LoginPage();

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        loginPage.verifyEtsyLogoIsDisplayed();

    }

    @Then("user logs in with {string} email and {string} password")
    public void user_logs_in_with_email_and_password(String email, String password) {
       loginPage.loginWithEtsyAccount(email,password);
    }






}

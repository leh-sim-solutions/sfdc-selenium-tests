package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.SalesForceLogIn;

import org.testng.Assert;

/**
 * LogInSteps.java.
 * Class for steps logIn.feature.
 */
public class LogInSteps {

    private SalesForceLogIn login;

    /**
     * Given step.
     */
    @Given("^I login as a User")
    public void iLoginAsUser() {
        login = new SalesForceLogIn("https://login.salesforce.com/");
        PropertiesManager prop = PropertiesManager.getInstance();
        login.logIn(prop.getUsername(), prop.getPassword(), prop.getTheme());
    }

    /**
     * Then step.
     */
    @Then("^Home Page should be displayed$")
    public void homePageShouldBeDisplated() {
        Assert.assertTrue(login.getCloudIcon());
    }

}

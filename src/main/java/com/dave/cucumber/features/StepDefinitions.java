package com.dave.cucumber.features;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;

/**
 * Created by David on 13/10/2017.
 */
@StepDefAnnotation
public class StepDefinitions {


    @Given("^blaA$")
    public void step1() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @When("^blaB$")
    public void step2() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @Then("^blaC$")
    public void step3() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }
}

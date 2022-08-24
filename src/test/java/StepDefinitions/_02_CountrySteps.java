package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _02_CountrySteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    @And("Navigate to Country Page")
    public void navigateToCountryPage() {
        ln.findAndClick("setupOne"); // setup click
        ln.findAndClick("parameters"); // parameters click
        ln.findAndClick("countries"); // countries click
    }

    @When("Create a Country")
    public void createACountry() {
        dc.findAndClick("acceptCookies");
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput","ulke151");
        dc.findAndSend("codeInput","1111");
        dc.findAndClick("saveButton");
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndContainsText("successMessage","success");
    }
    @When("Create a Country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String name, String code){
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput",name);
        dc.findAndSend("codeInput",code);
        dc.findAndClick("saveButton");
    }
}

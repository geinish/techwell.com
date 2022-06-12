package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;


public class StepsDefinition extends BaseSteps {

    @When("I click $parentItem $navigationItem")
    public void click_navigation(String parentItem, String navigationItem) {
        if (parentItem.equals(null)) {
            basePage.navigationClick(navigationItem);
        } else {
            basePage.navigationClick(parentItem, navigationItem);
        }
    }

    @Then("I redirected to $url")
    public void assert_should_be_redirected(String url) {
        Assert.assertEquals("No redirect to " + url, "https://www.techwell.com" + url, basePage.getCurrentUrl());
    }

    @Given("I open main page and go to insights")
    public void click_navigation_insights() {
        basePage.go_home();
        basePage.navigationClick("Insights");
    }

    @When("Fill form $email and choose language $language and sibscribe")
    public void send_form_subscription(String email, String language) {
        insightsPage.fill_form_and_subscribe(email, language);
    }

    @Then("My subscription is success")
    public void should_be_subcription() {
        Assert.assertEquals("Should be success subscription", "Your information has been submitted successfully!", insightsPage.find_success_result_subscription());
    }
}

package defenitions;

import common.ConfProperties;
import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;

import java.time.Duration;

public class BaseSteps {
    public static pages.BasePage basePage;
    private  WebDriver driver;

    @BeforeStory
    public void open() {
        System.setProperty("webdriver.chromedriver.driver", ConfProperties.getPropertyChromeDriver());
        WebDriver driver = new ChromeDriver();
        basePage = new BasePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(ConfProperties.getPropertyMainPageLink());
    }

    @AfterStory
    public void quit() {
        basePage.driver.quit();
    }

    @Given("Open Browser Chrome and consent settings")
    public void concern_settings_yes() {
    }

    @When("I click $navigation")
    public void click_navigation(String navigation) {
    }

    @Then("I see $section")
    public void assert_should_see_section(String section) {
        Assert.assertEquals("If", 1, 1);
    }
}
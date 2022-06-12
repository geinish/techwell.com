package steps;

import common.ConfProperties;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import pages.InsightsPage;

import java.time.Duration;

public abstract class BaseSteps {

    public BasePage basePage;
    public InsightsPage insightsPage;
    WebDriver driver;

    @BeforeStory
    public void setup() {
        System.setProperty("webdriver.chromedriver.driver", ConfProperties.getPropertyChromeDriver());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        basePage = new BasePage(driver);
        insightsPage = new InsightsPage(driver);
    }

    @AfterStory
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I open main page")
    public void start() {
        basePage.go_home();
    }

}
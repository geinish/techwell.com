package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InsightsPage {

    WebDriverWait wait;
    WebDriver driver;
    // Define page elements
    @FindBy(xpath = "//*[@id=\"edit-submitted-email\"]")
    private WebElement inputSubscriptionEmail;
    @FindBy(xpath = "//*[@id=\"edit-submitted-country\"]")
    private WebElement inputSubscriptionContry;
    @FindBy(css = "#webform-client-form-187643 > div > div.form-actions > button")
    private WebElement buttonSubscription;
    @FindBy(xpath = "//*[@id=\"edit-submitted-gdpr-consent-1\"]")
    private WebElement checkBoxConsent;
    @FindBy(xpath = "//*[@id=\"cboxLoadedContent\"]/iframe")
    private WebElement subscriptionFrame;

    @FindBy(xpath = "//*[@id=\"the-title\"]/h2")
    private WebElement subscriptionResultSuccessMessage;

    public InsightsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void fill_form_and_subscribe(String email, String language) {
        wait.until(ExpectedConditions.visibilityOf(subscriptionFrame));
        driver.switchTo().frame(subscriptionFrame);
        inputSubscriptionEmail.sendKeys(email);
        inputSubscriptionContry.sendKeys(language);
        buttonSubscription.click();
        checkBoxConsent.click();
        buttonSubscription.click();
    }

    public String find_success_result_subscription() {
        return subscriptionResultSuccessMessage.getText();
    }
}

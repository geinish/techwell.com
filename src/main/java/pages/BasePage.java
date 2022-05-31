package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /* Location */

    public void navigationClick(String menuItem) {
        String xpath_navigation = "//*/section[@id=\"block-jquerymenu-2\"]//*[.=\"" + menuItem + "\"]";
        driver.findElement(By.xpath(xpath_navigation)).click();
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
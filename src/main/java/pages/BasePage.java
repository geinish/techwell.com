package pages;

import common.ConfProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void navigationClick(String menuItem) {
        String xpath_navigation = "//*/section[@id=\"block-jquerymenu-2\"]//*[.=\"" + menuItem + "\"]";
        driver.findElement(By.xpath(xpath_navigation)).click();
    }

    public void navigationClick(String parentItem, String menuItem) {
        Actions act = new Actions(driver);

        String xpath_navigation = "//*/section[@id=\"block-jquerymenu-2\"]//*[.=\"" + parentItem + "\"]";
        WebElement parentItemWebElement = driver.findElement(By.xpath(xpath_navigation));
        act.moveToElement(parentItemWebElement).perform();

        String menuItemWebElement = "//*/section[@id=\"block-jquerymenu-2\"]//*[.=\"" + menuItem + "\"]";
        driver.findElement(By.xpath(menuItemWebElement)).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void go_home() {
        driver.get(ConfProperties.getPropertyMainPageLink());
    }

}
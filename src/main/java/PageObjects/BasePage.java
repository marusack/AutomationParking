package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public int timeout=15;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,timeout);
    }

    public void go(WebDriver driver){
        driver.get("http://adam.goucher.ca/parkcalc");
    }

    public void waitToBeVisible(By by){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

}

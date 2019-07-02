package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Utils.Utils.*;

public class ParkingForm extends BasePage {

    @FindBy(css = "input[value=\"Calculate\"]")
    public WebElement btnCalculate;

    @FindBy(css = "select#lot")
    public WebElement selectLot;

    @FindBy(css = "#EntryTime")
    public WebElement inputEntryTime;

    @FindBy(css = "#ExitTime")
    public WebElement inputExitTime;

    @FindBy(css = "#EntryDate")
    public WebElement entryDate;

    @FindBy(css = "#ExitDate")
    public WebElement exitDate;

    @FindBy (css = "input[name=\"EntryTimeAMPM\"" )
    public List<WebElement> entryDateCheckBox;

    @FindBy (css = "input[name=\"ExitTimeAMPM\"" )
    public List<WebElement> leavingDateCheckBox;

    public ParkingForm(WebDriver driver) {
        super(driver);
    }


    /**
     * Choose an specific lot by value
     */
    public void chooseALot(String lot) {
        select(lot,selectLot);
    }

    /**
     * Writes date for entryDate
     */
    public void chooseEntryDate(String date) {
        entryDate.clear();
        entryDate.sendKeys(date);
    }

    /**
     * Writes time for entry time and selects checkbox (am/pm)
     */
    public void chooseEntryTime(String time,String period) {
        inputEntryTime.clear();
        inputEntryTime.sendKeys(time);
        selectPeriod("AM",entryDateCheckBox);
    }

    /**
     * Writes date for LeavingDate
     */
    public void chooseLeavingDate(String date) {
        exitDate.clear();
        exitDate.sendKeys(date);
    }

    /**
     * Writes time for leaving time and selects checkbox (am/pm)
     */
    public void chooseLeavingTime(String time, String period) {
        inputExitTime.clear();
        inputExitTime.sendKeys(time);
        selectPeriod("AM",leavingDateCheckBox);
    }

    public String calculate() {
        btnCalculate.click();
        return driver.findElement(By.cssSelector("span.Subhead b")).getText();
    }

    public boolean messageIsDisplayed(String string, WebDriver driver) {
        return isTextDisplayed(string,driver);
    }
}

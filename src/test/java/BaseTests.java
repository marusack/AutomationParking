import PageObjects.ParkingForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import static Utils.Utils.*;

public abstract class BaseTests {
    protected WebDriver driver;

    @BeforeTest
    public void before(){
        driver= new ChromeDriver();
    }

    @AfterTest
    public void after(){
        //driver.quit();
    }

    @Test
    public void generalElementsTestLayOut(){
        ParkingForm landingPageParking = PageFactory.initElements(driver,ParkingForm.class);
        landingPageParking.go(driver);
        Assert.assertTrue(isElementDisplayedAndEnable(landingPageParking.selectLot),"The Select a lot dropbox is displayed");
        Assert.assertTrue(isElementDisplayedAndEnable(landingPageParking.entryDate),"The Entry Date is displayed");
        Assert.assertTrue(isElementDisplayedAndEnable(landingPageParking.inputEntryTime),"The Entry time is displayed");
        Assert.assertTrue(isElementDisplayedAndEnable(landingPageParking.exitDate),"The leaving Date is displayed");
        Assert.assertTrue(isElementDisplayedAndEnable(landingPageParking.inputExitTime),"The leaving time is displayed");
        Assert.assertTrue(isElementDisplayedAndEnable(landingPageParking.btnCalculate),"The Calculate button is displayed");
    }

}

import DataProvider.CVSDataProvider;
import PageObjects.ParkingForm;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Utils.Utils.validPrice;

/**
 * Tests under Short Term Test Suite
 */
public class ShortTermTestsSuite extends BaseTests {

    private ParkingForm pageParking;

    @BeforeMethod
    public void beforeTest(){
        this.pageParking = PageFactory.initElements(super.driver,ParkingForm.class);
        pageParking.go(driver);
    }

    /**
     * Test using data provider with data from csv
     * @param lot
     * @param date
     */
    @Test(dataProvider = "getDataFromCSV", dataProviderClass = CVSDataProvider.class)
    public void shortTermParking(String lot,String date){
        pageParking.chooseALot(lot);
        pageParking.chooseEntryDate("15/07/2019");
        pageParking.chooseEntryTime("12:00", "PM");
        pageParking.chooseLeavingDate(date);
        pageParking.chooseLeavingTime("12:30", "PM");
        pageParking.calculate();
        Assert.assertTrue(validPrice(pageParking.calculate()),"The result does not match with price format");
    }

    @Test
    public void shortTermParkingError(){
        pageParking.chooseALot("STP");
        pageParking.calculate();
        String errorMsg = "ERROR! Enter A Correctly Formatted Date";
        Assert.assertTrue(pageParking.messageIsDisplayed(errorMsg, driver),"The message "+errorMsg+" is not displayed on the page");
    }
}

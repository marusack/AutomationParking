import PageObjects.ParkingForm;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Utils.Utils.validPrice;


/**
 * Tests under Long Term Test Suite
 */
public class LongTermTestsSuite extends BaseTests {
    private ParkingForm pageParking;

    @BeforeMethod
    public void beforeTest(){
        this.pageParking = PageFactory.initElements(super.driver,ParkingForm.class);
        pageParking.go(driver);
    }

    /**
     * test using regular Data provider(no csv)
     */
    @Test(dataProvider = "longTermParking")
    public void longTermParking(String lot,String date){
        pageParking.chooseALot(lot);
        pageParking.chooseEntryDate("15/07/2019");
        pageParking.chooseEntryTime("12:00", "PM");
        pageParking.chooseLeavingDate(date);
        pageParking.chooseLeavingTime("12:30", "PM");
        Assert.assertTrue(validPrice(pageParking.calculate()),"The result does not match with price format");
    }

    /**
     * test simple data provider
     * @return
     */
    @DataProvider(name ="longTermParking")
    public Object[][] longTermParking(){
        return  new String[][]{
                {"LTS","15/12/2019"},
                {"LTG","15/07/2019"}
        };
    }

    @Test
    public void longTermParkingError(){
        pageParking.chooseALot("LTS");
        pageParking.calculate();
        String errorMsg = "ERROR! Enter A Correctly Formatted Date";
        Assert.assertTrue(pageParking.messageIsDisplayed(errorMsg, driver),"The message "+errorMsg+" is not displayed on the page");
    }
}

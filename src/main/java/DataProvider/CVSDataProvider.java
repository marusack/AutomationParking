package DataProvider;

import org.testng.annotations.DataProvider;

public class CVSDataProvider {

    @DataProvider(name= "getDataFromCSV")
    public static Object[][] getDataFromCSV(){
        return  CSVReader.getCsvdata();
    }
}

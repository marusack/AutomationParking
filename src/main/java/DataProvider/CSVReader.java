package DataProvider;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {


    private static com.opencsv.CSVReader reader=null;
    private static Object[][] csvdata=null;


    private static void getData(){

        String csvFile = "C:\\Users\\Maru\\Desktop\\AutomationUI\\src\\main\\resources\\data.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        csvdata= new String[1][1];
        try {

            br = new BufferedReader(new FileReader(csvFile));
            int i=0;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(cvsSplitBy);
                csvdata[i][i]=data[0];
                csvdata[i][i+1]=data[1];
                i++;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Object[][] getCsvdata(){
        getData();
        return csvdata;
    }
}
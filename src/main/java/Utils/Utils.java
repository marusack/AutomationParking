package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Utils {


    /**
     * Selects by value given a select      *
     * @param value  option selected value
     * @param select web element
     */
    public static void select(String value, WebElement select){
        Select sel = new Select(select);
        sel.selectByValue(value);
    }

    /**
     * given a list of checkboxes select the option by value
     * @param period AM/PM
     * @param list  of checkboxes
     */
    public static void selectPeriod(String period, List<WebElement> list){
        if (period.equals("AM")){
            list.get(0).click();
        }else {
            list.get(1).click();
        }
    }

    public static boolean isElementDisplayedAndEnable(WebElement element){
        return element.isDisplayed() && element.isEnabled();
    }

    public static boolean isTextDisplayed(String string, WebDriver driver) {
        List<WebElement> found = driver.findElements(By.xpath("//*[contains(text(), '"+string+"')]"));
        return  found.size()>0;
    }

    public static boolean validPrice(String price){
        String pattern = "^\\$ \\d+(,\\d{3})*(\\.\\d{1,2})?$";
        Pattern pat = Pattern.compile(pattern);
        Matcher matcher =pat.matcher(price);
        return matcher.find();
    }
}

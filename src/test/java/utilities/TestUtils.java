package utilities;

import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

public  class TestUtils {
    /**
     *
     * @param pattern
     * d MMMMM yyyy - > 2 December 2018
     * @return system date
     */
    public static String getCurrentDate(String pattern){
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(today);
    }

    public static By getXpath(String currentXpath,String pattern, String replacePattern){

        return By.xpath(currentXpath.replace(pattern,replacePattern));
    }
}

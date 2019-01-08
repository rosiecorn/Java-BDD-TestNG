package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

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


    public static String formatDate(String pattern, String strDate){
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(strDate);
            return new SimpleDateFormat(pattern).format(date);
        }
        catch(Exception e)
        {
            return "";
        }
    }

    public static By getXpath(String currentXpath,String pattern, String replacePattern){

        return By.xpath(currentXpath.replace(pattern,replacePattern));
    }

    public static By getXpath(String currentXpath,String replacePattern){

        return By.xpath(currentXpath.replace("%",replacePattern));
    }


    public static WebElement randomElement(List<WebElement> links)
    {
       return links.get(new Random().nextInt(links.size()));
    }

    public static void randomLinksClick(List<WebElement> links)
    {
         links.get(new Random().nextInt(links.size())).click();
    }
}

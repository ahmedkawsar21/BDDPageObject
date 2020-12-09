package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class ReusableMethods extends BaseApi{
    public static void addItems(String[] names) {
        int j=0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i=0; i<products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String nameVeggie = name[0].trim();
            List<String> items = Arrays.asList(names);
            if (items.contains(nameVeggie)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
                if (j==names.length) {
                    break;
                }
            }
        }
    }
}

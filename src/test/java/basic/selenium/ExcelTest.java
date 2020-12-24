package basic.selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.BaseApi;
import utils.ExcelReader;

import java.io.IOException;
import java.util.ArrayList;

public class ExcelTest extends BaseApi {
    @Test
    public void excelTest() throws IOException {
        ExcelReader d = new ExcelReader();
        ArrayList<String> data = d.getData("purchase","testData");
        data.get(0);
        data.get(1);
        data.get(2);
        data.get(3);
        driver.findElement(By.id("")).sendKeys(data.get(1));


    }

}

package pages;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseApi;
import utils.Pages;

public class CalenderHandle extends BaseApi {
    public Pages pages;
    @BeforeMethod
    public void init() {
        pages= PageFactory.initElements(driver,Pages.class);
    }

    @Test
    public void testHandleCalender() throws InterruptedException {
        pages.clickDateSearch();
        int count = pages.monthView().size();
        while (!pages.getMonthName().getText().contains("March")){
            pages.clickNextMonth();
        }
        for (int i=0; i<count;i++) {
            String dates = pages.monthView().get(i).getText();
            if (dates.equalsIgnoreCase("23")) {
                pages.monthView().get(i).click();
                break;
            }

        }
        Thread.sleep(2000);

    }
}

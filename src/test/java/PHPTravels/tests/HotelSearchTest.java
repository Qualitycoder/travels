package PHPTravels.tests;

import PHPTravels.pages.HotelSearchPage;
import PHPTravels.pages.ResultsPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class HotelSearchTest extends BaseTest {

    @Test
    public void searchHotelTest() {

        ExtentTest test = extentReports.createTest("Search Hotel Test");
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setCity("Dubai");
        test.log(Status.PASS, "Setting city done");
        hotelSearchPage.setDates("02.04.2023", "06.04.2023");
        test.log(Status.PASS, "Setting dates done");
        hotelSearchPage.setTravellers(0, 1);
        test.log(Status.PASS, "Setting travellers done");
        hotelSearchPage.setSearchButton();
        test.log(Status.PASS, "Setting button done");

        ResultsPage resultsPage = new ResultsPage(driver);
        List<String> hotelNames = resultsPage.getHotelNames();


        Assert.assertEquals("Jumeirah Beach Hotel", hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower", hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana", hotelNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth", hotelNames.get(3));
        test.log(Status.PASS, "Assertions passed");

    }
}

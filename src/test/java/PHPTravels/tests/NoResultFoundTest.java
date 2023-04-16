package PHPTravels.tests;

import PHPTravels.pages.HotelSearchPage;
import PHPTravels.pages.ResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NoResultFoundTest extends BaseTest {
    @Test
    public void noResultFoundTest() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setDates("02/04/2023", "06/04/2023");
        hotelSearchPage.setTravellers(0, 1);
        hotelSearchPage.setSearchButton();

        ResultsPage resultsPage = new ResultsPage(driver);


        Assert.assertTrue(resultsPage.noResultInfo.isDisplayed());
        Assert.assertEquals(resultsPage.findNoResult(), "No Results Found");

    }
}

package PHPTravels;

import PHPTravels.pages.HotelSearchPage;
import PHPTravels.pages.ResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NoResultFoundTest extends BaseTest {
    @Test
    public void homeworkTest() {

        ResultsPage resultsPage = new HotelSearchPage(driver)
                .setDates("02/04/2023", "06/04/2023")
                .setTravellers(0, 1)
                .setSearchButton();


        Assert.assertTrue(resultsPage.noResultInfo.isDisplayed());
        Assert.assertEquals(resultsPage.findNoResult(), "No Results Found");

    }
}

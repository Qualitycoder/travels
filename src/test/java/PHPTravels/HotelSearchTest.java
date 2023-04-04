package PHPTravels;

import PHPTravels.pages.HotelSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class HotelSearchTest extends BaseTest {

    @Test
    public void searchHotelTest() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        List<String> hotelNames = hotelSearchPage.setCity("Dubai")
                .setDates("02.04.2023", "06.04.2023")
                .setTravellers(0, 1)
                .setSearchButton().getHotelNames();


        Assert.assertEquals("Jumeirah Beach Hotel", hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower", hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana", hotelNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth", hotelNames.get(3));


    }
}

package PHPTravels.tests;

import PHPTravels.pages.HotelSearchPage;
import PHPTravels.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongEmailTest extends BaseTest {
    @Test
    public void wrongEmail() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();


        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setName("Michał");
        signUpPage.setLastName("Testowy");
        signUpPage.setPhone("696696969");
        signUpPage.setEmail("email");
        signUpPage.setPassword("111111");
        signUpPage.confirmPassword("111111");
        signUpPage.setSignUpBtn();


        Assert.assertTrue(signUpPage.getErrors().contains("The Email field must contain a valid email address."));


    }
}

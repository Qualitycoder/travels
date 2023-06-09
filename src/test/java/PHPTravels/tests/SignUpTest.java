package PHPTravels.tests;

import PHPTravels.pages.HotelSearchPage;
import PHPTravels.pages.LoggedUserPage;
import PHPTravels.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignUpTest extends BaseTest {

    @Test
    public void signUp() {

        String lastname = "Testowy";

        int randomNumber = (int) (Math.random() * 1000);
        String email = "Tester" + randomNumber + "@wp.pl";

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.setName("Michał");
        signUpPage.setLastName("Testowy");
        signUpPage.setPhone("111111111");
        signUpPage.setEmail(email);
        signUpPage.setPassword("111111");
        signUpPage.confirmPassword("111111");
        signUpPage.setSignUpBtn();

        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);


        Assert.assertTrue(loggedUserPage.getHeadingText().contains("Testowy"));
        Assert.assertEquals(loggedUserPage.getHeadingText(), "Hi, Michał Testowy");


    }
}

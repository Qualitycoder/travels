package PHPTravels;

import PHPTravels.pages.HotelSearchPage;
import PHPTravels.pages.LoggedUserPage;
import PHPTravels.pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class WrongEmailTest extends BaseTest {
    @Test
    public void wrongEmail() {


        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.setName("Michał");
        signUpPage.setLastName("Testowy");
        signUpPage.setPhone("111111111");
        signUpPage.setEmail("email");
        signUpPage.setPassword("111111");
        signUpPage.confirmPassword("111111");
        signUpPage.setSignUpBtn();
signUpPage.getErrors();




        Assert.assertTrue(signUpPage.getErrors().contains("The Email field must contain a valid email address."));


    }
}

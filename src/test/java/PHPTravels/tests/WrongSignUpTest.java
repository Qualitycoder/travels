package PHPTravels.tests;

import PHPTravels.pages.HotelSearchPage;
import PHPTravels.pages.SignUpPage;
import PHPTravels.tests.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WrongSignUpTest extends BaseTest {


    @Test
    public void Errors() {


        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setSignUpBtn();
        signUpPage.getErrors();





        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(signUpPage.getErrors().contains("The Email field is required."));
        softAssert.assertTrue(signUpPage.getErrors().contains("The Password field is required."));
        softAssert.assertTrue(signUpPage.getErrors().contains("The Password field is required."));
        softAssert.assertTrue(signUpPage.getErrors().contains("The First name field is required."));
        softAssert.assertTrue(signUpPage.getErrors().contains("The Last Name field is required."));
        softAssert.assertAll();


    }
}

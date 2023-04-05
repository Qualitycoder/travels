package PHPTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

public class WrongSignUpTest extends BaseTest {


    @Test
    public void errors() {

        driver.findElements(By.id("li_myaccount")).stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[@class='go-text-right' and text()='  Sign Up']")).stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        driver.findElement(By.xpath("//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']")).click();


        List<String> alerts = driver.findElements(By.xpath("//div[@class='alert alert-danger']//p")).stream().map(WebElement::getText)
                .collect(Collectors.toList());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(alerts.contains("The Email field is required."));
        softAssert.assertTrue(alerts.contains("The Password field is required."));
        softAssert.assertTrue(alerts.contains("The Password field is required."));
        softAssert.assertTrue(alerts.contains("The First name field is required."));
        softAssert.assertTrue(alerts.contains("The Last Name field is required."));
        softAssert.assertAll();


    }
}

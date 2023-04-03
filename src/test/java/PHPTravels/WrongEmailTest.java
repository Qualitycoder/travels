package PHPTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class WrongEmailTest extends BaseTest {
    @Test
    public void wrongEmail(){
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().window().maximize();
        driver.findElements(By.id("li_myaccount")).stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[@class='go-text-right' and text()='  Sign Up']")).stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);



        driver.findElement(By.name("firstname")).sendKeys("Michal");
        driver.findElement(By.name("lastname")).sendKeys("Testowy");
        driver.findElement(By.name("phone")).sendKeys("696696696");
        driver.findElement(By.name("email")).sendKeys("randomEmail");
        driver.findElement(By.name("password")).sendKeys("111111");
        driver.findElement(By.name("confirmpassword")).sendKeys("111111");

        driver.findElement(By.xpath("//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']")).click();

        List<String> alert =  driver.findElements(By.xpath("//div[@class='alert alert-danger']//p")).stream().map(WebElement::getText)
                .collect(Collectors.toList());
   Assert.assertTrue(alert.contains("The Email field must contain a valid email address."));

        driver.quit();
    }
}

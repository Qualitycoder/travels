package PHPTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class SignUpTest extends BaseTest {

    @Test
    public void signUp(){

        driver.findElements(By.id("li_myaccount")).stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[@class='go-text-right' and text()='  Sign Up']")).stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);

        String lastname = "Testowy";

        int randomNumber = (int) (Math.random()*1000);
        String email = "Tester" + randomNumber + "@wp.pl";



        driver.findElement(By.name("firstname")).sendKeys("Michal");
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.name("phone")).sendKeys("696696696");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("111111");
        driver.findElement(By.name("confirmpassword")).sendKeys("111111");

        driver.findElement(By.xpath("//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         WebElement heading = driver.findElement(By.xpath("//h3[@class='RTL' and text()='Hi, Michal Testowy']"));

        Assert.assertTrue(heading.getText().contains(lastname));
        Assert.assertEquals(heading.getText(),"Hi, Michal Testowy");


    }
}

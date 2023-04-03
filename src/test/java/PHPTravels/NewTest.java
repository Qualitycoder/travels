package PHPTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class NewTest extends BaseTest {
    @Test
    public void  KUPA(){
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.name("checkin")).click();

        driver.findElements(By.xpath("//th[@class='next']"))
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);

        driver.findElements(By.xpath("//td[@class='day ' and text()= '1']"))
                .stream()
                .filter(el -> el.isDisplayed())
                .findFirst()
                .ifPresent(el -> el.click());

        driver.findElements(By.xpath("//td[@class='day ' and text()= '6']"))
                .stream()
                .filter(el -> el.isDisplayed())
                .findFirst()
                .ifPresent(el -> el.click());

        //dodajemy jedno dziecko i jednego rodzica

        driver.findElement(By.id("travellersInput")).click();
        driver.findElement(By.id("childPlusBtn")).click();

        driver.findElement(By.xpath("//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']")).click();
        driver.findElement(By.xpath("//h2[@class='text-center']"));
        // Assert.assertTrue(noResult.getText().contains("No Results Found"));
        //Assert.assertEquals(noResult,"No Results Found");

driver.quit();


    }
}

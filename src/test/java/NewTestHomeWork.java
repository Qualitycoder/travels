import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class NewTestHomeWork {
    @Test
    public void homeworkTest(){
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //dodanie daty
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

        //dodanie dziecka
        driver.findElement(By.id("travellersInput")).click();
        driver.findElement(By.id("childPlusBtn")).click();



        //nacisniecie pryzsku szukaj i dodanie asercji o widocznosci "no found result"
        driver.findElement(By.xpath("//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']")).click();



       WebElement noResult = driver.findElement(By.xpath("//div[@class='itemscontainer']//h2"));
       Assert.assertTrue(noResult.isDisplayed());
       Assert.assertEquals("No Results Found",noResult.getText());





    }
}

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HotelSearch{

    @Test
    public void test(){
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[text()= 'Search by Hotel or City Name']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Dubai");
        driver.findElement(By.xpath("//span[@class='select2-match' and text()='Dubai']" )).click();
        driver.findElement(By.name("checkin")).sendKeys("01/04/2023");
        driver.findElement(By.name("checkout")).sendKeys("04/04/2023");
        

        //driver.quit();






    }
}

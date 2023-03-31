import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class HotelSearch{

    @Test
    public void searchHotel(){
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[text()= 'Search by Hotel or City Name']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Dubai");
        driver.findElement(By.xpath("//span[@class='select2-match' and text()='Dubai']" )).click();
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
        driver.findElement(By.id("adultPlusBtn")).click();
        driver.findElement(By.id("childPlusBtn")).click();

        driver.findElement(By.xpath("//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']")).click();
        List<String> hotelsNames = driver.findElements(By.xpath("//h4[@class='RTL go-text-right mt0 mb4 list_title']")).stream()
                .map(el -> el.getAttribute("textContent"))
                .collect(Collectors.toList());

        hotelsNames.forEach(System.out::println);


        Assert.assertEquals("Jumeirah Beach Hotel",hotelsNames.get(0));
        Assert.assertEquals("Oasis Beach Tower",hotelsNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana",hotelsNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth",hotelsNames.get(3));





    }
}

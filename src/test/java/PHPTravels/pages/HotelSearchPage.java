package PHPTravels.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelSearchPage {


    private WebDriver driver;

    public HotelSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//span[text()= 'Search by Hotel or City Name']")
    private WebElement searchHotelSpan;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement searchHotelInput;

    @FindBy(xpath = "//div[@class='select2-result-label']//span")
    private WebElement hotelMatch;

    @FindBy(name = "checkin")
    private WebElement checkinInput;

    @FindBy(name = "checkout")
    private WebElement checkoutInput;

    @FindBy(id = "travellersInput")
    private WebElement travellersInput;

    @FindBy(id = "adultPlusBtn")
    private WebElement adultPlusBtn;

    @FindBy(id = "childPlusBtn")
    private WebElement childPlusBtn;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@class='go-text-right' and text()='  Sign Up']")
    private List<WebElement> signUpLink;

    @FindBy(id = "li_myaccount")
    private List<WebElement> myAccountLink;
    private static final Logger logger = LogManager.getLogger();

    public void setCity(String cityName) {
        logger.info("Setting city"+ cityName);
        searchHotelSpan.click();
        searchHotelInput.sendKeys(cityName);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", cityName);
        driver.findElement(By.xpath(xpath)).click();
        logger.info("Setting city done.");
    }

    public void setDates(String checkin, String checkout) {
        logger.info("Setting dates check-in:"+ checkin + "and check-out:" + checkout);
        checkinInput.sendKeys(checkin);
        checkoutInput.sendKeys(checkout);
        logger.info("Done");
    }


    public void setTravellers(int adultsToAdd, int childsToAdd) {
        logger.info("Add adults:"+ adultsToAdd + "and childs" + childsToAdd);
        travellersInput.click();
        addTraveler(adultPlusBtn, adultsToAdd);
        addTraveler(childPlusBtn, childsToAdd);
        logger.info("Add adults and childs done.");
    }

    private void addTraveler(WebElement travelerBtn, int numberOfTravellers) {
        for (int i = 0; i < numberOfTravellers; i++) {
            travelerBtn.click();
        }
    }

    public void setSearchButton() {
        searchButton.click();
    }

    public void openSignUpForm() {
        myAccountLink.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        signUpLink.get(1).click();
    }
}




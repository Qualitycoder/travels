package PHPTravels.pages;

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

    @FindBy(id = "li_myaccount")
    private List<WebElement> myAccountLink;

    @FindBy(xpath = "//a[@class='go-text-right' and text()='  Sign Up']")
    private List<WebElement> signUpLink;


    public HotelSearchPage setCity(String cityName) {
        searchHotelSpan.click();
        searchHotelInput.sendKeys(cityName);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", cityName);
        driver.findElement(By.xpath(xpath)).click();
        return this;
    }

    public HotelSearchPage setDates(String checkin, String checkout) {
        checkinInput.sendKeys(checkin);
        checkoutInput.sendKeys(checkout);
        return this;
    }

    public HotelSearchPage setTravellers(int adultsToAdd, int childsToAdd) {
        travellersInput.click();
        addTraveler(adultPlusBtn, adultsToAdd);
        addTraveler(childPlusBtn, childsToAdd);
        return this;
    }

    private void addTraveler(WebElement travelerBtn, int numberOfTravellers) {
        for (int i = 0; i < numberOfTravellers; i++) {
            travelerBtn.click();
        }
    }

    public ResultsPage setSearchButton() {
        searchButton.click();
        return new ResultsPage(driver);
    }

    public SignUpPage openSignUpForm() {
        myAccountLink.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);

        signUpLink.get(1).click();
        return new SignUpPage(driver);
    }

}




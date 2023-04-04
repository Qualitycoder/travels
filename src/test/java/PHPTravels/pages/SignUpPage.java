package PHPTravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SignUpPage {

    @FindBy(xpath = "//div[@class='alert alert-danger']//p")
    private List<WebElement> errors;

    @FindBy(name = "firstname")
    private WebElement nameInput;

    @FindBy(name = "lastname")
    private WebElement lastnameInput;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "confirmpassword")
    private WebElement confirmpasswordInput;

    @FindBy(xpath = "//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']")
    private WebElement signUpBtn;

    public void setName(String firstname) {
        nameInput.sendKeys(firstname);
    }

    public void setLastName(String lastname) {
        lastnameInput.sendKeys(lastname);
    }

    public void setPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void confirmPassword(String password) {
        confirmpasswordInput.sendKeys(password);
    }

    public void setSignUpBtn() {
        signUpBtn.click();
    }

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> getErrors() {
        return errors.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

    }

}

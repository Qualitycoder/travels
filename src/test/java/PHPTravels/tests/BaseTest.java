package PHPTravels.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    public FirefoxDriver driver;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentReports extentReports;


    @BeforeSuite
    public void beforeSuite() {
        htmlReporter = new ExtentHtmlReporter("index.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @AfterSuite
    public void afterSuite() {
        htmlReporter.flush();
        extentReports.flush();
    }

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}

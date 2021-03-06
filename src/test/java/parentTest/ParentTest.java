package parentTest;

import pages.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class ParentTest {
    protected WebDriver webDriwer;
    String browser = System.getProperty("browser");

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected AkciiPage akciiPage;
    protected ProductPage productPage;
    protected PageWithFoundProduct pageWithFoundProduct;

    @Before
    public void setUP() {
        if (browser == null || "chrome".equals(browser.toLowerCase())) {
            File file = new File("./src/drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

            webDriwer = new ChromeDriver();
        } else if ("firefox".equals(browser.toLowerCase())) {
            File file = new File("./src/oldDrivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
            FirefoxOptions profile = new FirefoxOptions();
            profile.addPreference("browser.startup.page", 0);
            profile.addPreference("browser.startup.homepage_overdrive.mstone", "ignore");//Suppress the "What's new" page
            webDriwer = new FirefoxDriver();
        }
        webDriwer.manage().window().maximize();
        webDriwer.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        homePage = new HomePage(webDriwer);
        loginPage = new LoginPage(webDriwer);
        akciiPage = new AkciiPage(webDriwer);
        productPage = new ProductPage(webDriwer);
        pageWithFoundProduct = new PageWithFoundProduct(webDriwer);
    }
    @After
    public void tearDown() {webDriwer.quit();}

    public void checkExpectedResult(String message, boolean expectedResult, boolean actualResult) {
        Assert.assertEquals(message, expectedResult, actualResult);
    }
}

package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    @FindBy(xpath = ".//input[@class='submit button_search']")
    private WebElement buttonMagnifier;
    @FindBy(xpath = ".//*[@class='wrap_logo']")
    private WebElement logo;
    @FindBy(xpath = ".//a[@class='button_fb']")
    private WebElement iconFB;
    @FindBy(id = "facebook")
    private WebElement FBlink;
    @FindBy(xpath = ".//*[@class = 'home']")
    private WebElement avatar;
    @FindBy (xpath = ".//*[@class=\"wrap_topmenu\"]/a[2]")
    private WebElement AkciiButton;

    public void openPage() {
        try {
            webDriver.get("http://motomen.com.ua");
            logger.info("Page was opened");
        } catch (Exception e) {
            logger.error("Can not open LoginPage");
            Assert.fail("Can not open LoginPage");
        }
    }


    public void clickOnButtonMagnifier() {
        try {
            buttonMagnifier.click();
            logger.info("Button magnifier was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public boolean isLogoPresent() {
        return actionsWithOurElements.isElementDisplayed(logo);
    }

    public void clickOnFBIcon() {
        try {
            iconFB.click();
            logger.info("FB icon was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void clickOnAkciiButton() {
        actionsWithOurElements.clickOnElement(AkciiButton);
    }
}

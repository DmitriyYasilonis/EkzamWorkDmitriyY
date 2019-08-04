package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextInput;


    public class LoginPage extends ParentPage {public LoginPage(WebDriver webDriver) {super(webDriver, "/system");
        }

    @FindBy(name = "username")
    private TextInput inputLogin;
    @FindBy(name = "password")
    private TextInput inputPass;
    @FindBy (xpath = ".//*[@value= 'Вход']")
    private WebElement buttonVhod;
    @FindBy (xpath = ".//*[@class = 'home']")
    private WebElement avatar;

        public void openPage() {
            try {
                webDriver.get("http://motomen.com.ua/system");
                logger.info("LoginPage was opened");
            } catch (Exception e) {
                logger.error("Can not open LoginPage");
                Assert.fail("Can not open LoginPage");
            }
        }

    public void loginWithCred(String login, String pass){
        openPage();
        checkCurrentUrl();
        enterTextInToInputLogin(login);
        enterTextInToInputPassword(pass);
        clickOnButtonVhod();
    }

    public void enterTextInToInputLogin(String login) {
        actionsWithOurElements.enterTextIntoInput(inputLogin, login);
    }

    public void enterTextInToInputPassword(String login) {
        actionsWithOurElements.enterTextIntoInput(inputPass, login);
    }

    public void clickOnButtonVhod(){
        try {
            buttonVhod.click();
            logger.info("Button vhod was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public boolean isAvatarPresent (){
        return actionsWithOurElements.isElementDisplayed(avatar);
    }



    }

package searchTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageWithFoundProduct;
import parentTest.ParentTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SearchTest extends ParentTest {


    @Test
    public void EmptySearch() {
        homePage.openPage();
        homePage.clickOnButtonMagnifier();
        checkExpectedResult("Logo is present"
                , true
                , homePage.isLogoPresent());
    }


    @Test
    public void NotEmptySearchAndSelect(){
        homePage.openPage();
        homePage.enterTextIntoSearchField("acerbis");
        homePage.clickOnButtonMagnifier();
        pageWithFoundProduct.clickOnFirstFoundProduct();
        productPage.checkIsBuyDisplayed();
        checkExpectedResult("Buy button is  present"
                , true
                , productPage.isBuyPresent());
    }
}

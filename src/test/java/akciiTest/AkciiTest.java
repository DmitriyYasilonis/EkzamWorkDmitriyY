package akciiTest;

import org.junit.Test;
import pages.ParentPage;
import parentTest.ParentTest;

public class AkciiTest extends ParentTest {

    @Test
    public  void openProductFromAkcii(){
        homePage.openPage();
        homePage.clickOnAkciiButton();

//        akciiPage.checkCurrentUrl();
        akciiPage.clickOnFirstProduct();

        productPage.checkIsBuyDisplayed();
//        productPage.checkCurrentUrl();

        checkExpectedResult("Buy button is  present"
                , true
                , productPage.isBuyPresent());


    }
}

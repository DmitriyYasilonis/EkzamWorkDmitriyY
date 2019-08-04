package linkTest;

import org.junit.Test;
import parentTest.ParentTest;


public class LinkTest extends ParentTest {
    @Test
    public void FBLink() {
        homePage.openPage();
        homePage.clickOnFBIcon();
        homePage.checkNotCurrentUrl();
    }
}


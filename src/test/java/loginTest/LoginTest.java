package loginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {

    // V etom teste dumayu chto to naputal s URL (http://motomen.com.ua/system)
    @Test
    public void unvalidPassword() {
        loginPage.loginWithCred("manager", "H256DFwjey73");
        checkExpectedResult("Avatar shoud not be present"
                , false
                , loginPage.isAvatarPresent());
    }

    @Test
    public void validLogin() {
        loginPage.openPage();
    }
}
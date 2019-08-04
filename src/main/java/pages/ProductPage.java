package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends ParentPage{public ProductPage(WebDriver webDriver) {super(webDriver, "/catalog/*");
}

    @FindBy(id = "unit_add_to_cart")
    private WebElement buy;

    public boolean isBuyPresent () {
        return actionsWithOurElements.isElementDisplayed(buy);
    }
    public void checkIsBuyDisplayed(){
        Assert.assertTrue("Buy button is present", isBuyPresent());
    }
}

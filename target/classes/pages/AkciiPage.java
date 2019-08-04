package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AkciiPage extends ParentPage{public AkciiPage(WebDriver webDriver) {super(webDriver, "/catalog/actions");
}

    @FindBy(xpath = ".//*[@id=\"unit_items_catalog\"]/a[1]")
    private WebElement clickOnFirstProduct;

    public void clickOnFirstProduct() {
        actionsWithOurElements.clickOnElement(clickOnFirstProduct);
    }
}

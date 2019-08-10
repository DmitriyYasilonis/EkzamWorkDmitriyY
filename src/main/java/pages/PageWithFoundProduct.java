package pages;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;

public class PageWithFoundProduct extends ParentPage {public PageWithFoundProduct(WebDriver webDriver) {super(webDriver, "/catalog/search/*");}

    @FindBy(xpath = ".//*[@id=\"unit_items_catalog\"]/a[1]")
    private WebElement clickOnFirstFoundProduct;

    public void clickOnFirstFoundProduct() {
        actionsWithOurElements.clickOnElement(clickOnFirstFoundProduct);
    }
}
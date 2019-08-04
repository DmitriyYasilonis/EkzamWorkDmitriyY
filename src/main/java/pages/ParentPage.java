package pages;

import org.junit.Assert;
import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.regex.Pattern;

abstract public class ParentPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    ActionsWithOurElements actionsWithOurElements;



    public static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);

    String baseURL;
    String expectedUrl;


    public ParentPage(WebDriver webDriver, String partURL) {
        this.webDriver = webDriver;
        baseURL = configProperties.base_url();
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriver)), this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        expectedUrl = baseURL + partURL;
    }

    public void checkCurrentUrl() {
        try {
            Assert.assertEquals("URL is not expected"
                    , Pattern.matches(expectedUrl
                            , webDriver.getCurrentUrl())
                    , true
            );
        } catch (Exception e) {
            logger.error("Can not get URL" + e);
            Assert.fail("Can not get URL");
        }
    }

    public void checkNotCurrentUrl() {
        try {
            Assert.assertEquals("URL is nor expected"
                    , Pattern.matches(expectedUrl
                            , webDriver.getCurrentUrl())
                    , false
            );
        } catch (Exception e) {
            logger.error("Can not get URL" + e);
            Assert.fail("Can not get URL");
        }
    }
}

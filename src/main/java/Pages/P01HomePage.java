package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static Utility.Utilities.scrollToAndClick;

public class P01HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final int TIMEOUT = 30;


    public P01HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    private final By registerTab = By.cssSelector("i[class=\"mdi-account-outline mdi v-icon notranslate v-theme--light v-icon--size-default\"]");
    public P01HomePage registerBTN ()
    {
        scrollToAndClick(driver, registerTab);
        return this;
    }
}

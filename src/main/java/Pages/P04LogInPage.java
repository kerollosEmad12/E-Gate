package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static Utility.Utilities.scrollToAndClick;
public class P04LogInPage {

    private WebDriver driver;

    private WebDriverWait wait;

    private static final int TIMEOUT = 30;

    public P04LogInPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    private final By email = By.cssSelector("input[type=\"text\"]:nth-child(3)");
    public P04LogInPage EnterEmail (String Email)
    {
        driver.findElement(email).sendKeys(Email);
        return this;
    }

    private final By password = By.cssSelector("input[type=\"password\"]");
    public P04LogInPage EnterPass (String pass)
    {
        driver.findElement(password).sendKeys(pass);
        return this;
    }

    private final By signUp = By.cssSelector("button[type=\"submit\"]");
    public P04LogInPage signUPBTN ()
    {
        scrollToAndClick(driver, signUp);
        return this;
    }
}

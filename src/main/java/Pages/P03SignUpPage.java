package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static Utility.Utilities.scrollToAndClick;

public class P03SignUpPage {
    private WebDriver driver;

    private WebDriverWait wait;

    private static final int TIMEOUT = 30;

    public P03SignUpPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    private final By signup = By.cssSelector("a[href=\"/auth/register\"]");
    public P03SignUpPage signupBTN()
    {
        scrollToAndClick(driver, signup);
        return this;
    }

    private final By close = By.className("closeMenuX");
    public P03SignUpPage closeMenu()
    {
        scrollToAndClick(driver, close);
        return this;
    }

    private final By firstName = By.id("firstName");
    public P03SignUpPage fName (String FirstName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        wait.until(ExpectedConditions.elementToBeClickable(firstName));
        driver.findElement(firstName).sendKeys(FirstName);
        return this;
    }

    private final By lastName = By.id("lastName");
    public P03SignUpPage lName (String LastName)
    {
        driver.findElement(lastName).sendKeys(LastName);
        return this;
    }

    private final By Email = By.id("email");
    public P03SignUpPage email (String mail)
    {
        driver.findElement(Email).sendKeys(mail);
        return this;
    }

    private final By Mobile = By.id("mobile");
    public P03SignUpPage phone (String Number)
    {
        driver.findElement(Mobile).sendKeys(Number);
        return this;
    }

    private final By password = By.cssSelector("input[type=\"password\"]:nth-child(2)");
    public P03SignUpPage pass(String PASS) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        wait.until(ExpectedConditions.elementToBeClickable(password));
        WebElement passwordElement = driver.findElement(password);
        passwordElement.clear();
        passwordElement.sendKeys(PASS);
        return this;
    }


    private final By confPassword = By.cssSelector("div[class=\"mb-3\"]:nth-child(6) input[type=\"password\"]:nth-child(2)");
    public P03SignUpPage confPass (String ConfPASSWORD)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confPassword));
        wait.until(ExpectedConditions.elementToBeClickable(confPassword));
        WebElement passwordElement = driver.findElement(confPassword);
        passwordElement.clear();
        passwordElement.sendKeys(ConfPASSWORD);
        return this;
    }

    private final By create = By.cssSelector("button[class=\"buy-btn\"]:nth-child(1)");
    public P03SignUpPage CreateBTN ()
    {
        scrollToAndClick(driver, create);
        return this;
    }

    private final By clear = By.cssSelector("button[class=\"view-btn border-gray color-gray\"]");
    public P03SignUpPage clearBTN()
    {
        scrollToAndClick(driver, clear);
        return this;
    }
}

import Pages.P01HomePage;
import Pages.P02DataDrivenPage;
import Pages.P03SignUpPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class T02SignUp extends T01TestBase {

    protected P03SignUpPage sign;

    public static String globalEmail;

    SoftAssert soft = new SoftAssert();
    Faker faker = new Faker();

    @Test (priority = 1, dataProvider = "Invalid first name and last name", dataProviderClass = P02DataDrivenPage.class)
    public void InvalidFNameAndLName (String firstName, String lastName)
    {
        home = new P01HomePage(driver);
        sign = new P03SignUpPage(driver);

        home.registerBTN();

        sign.signupBTN();
        sign.closeMenu();
        sign.fName(firstName);
        sign.lName(lastName);
        globalEmail = faker.internet().emailAddress();
        sign.email(globalEmail);
        String phoneNumber = faker.numerify("010########");
        sign.phone(phoneNumber);
        sign.pass("Test123!");
        sign.confPass("Test123!");
        sign.CreateBTN();

        List<WebElement> elements = driver.findElements(By.cssSelector("div[class=\"mb-3\"] div[class=\"error text-red\"]"));

        String actualMsg = "The first name field is required., The last name field is required.";

        try {
            actualMsg = driver.findElement(By.cssSelector("div[class=\"mb-3\"] div[class=\"error text-red\"]")).getText();
        } catch (NoSuchElementException e) {
            soft.fail("The first name field is required., The last name field is required.");
        }
        switch (actualMsg){
            case "The first name field is required., The first name must be at least 3 characters.":
                soft.assertTrue(false, "actualMsg: "+actualMsg+" | "+ "expectedMsg: "+"The first name field is required.");
                break;
            case "The last name field is required., The last name must be at least 3 characters.":
                break;
        }
        soft.assertAll();
    }

    @Test (priority = 2, dataProvider = "Invalid Email", dataProviderClass = P02DataDrivenPage.class)
    public void InvalidEmail (String email)
    {
        home = new P01HomePage(driver);
        sign = new P03SignUpPage(driver);

        home.registerBTN();

        sign.signupBTN();
        sign.closeMenu();
        sign.fName("Kerolos");
        sign.lName("Emad");
        sign.email(email);
        String phoneNumber = faker.numerify("010########");
        sign.phone(phoneNumber);
        sign.pass("Test123!");
        sign.confPass("Test123!");
        sign.CreateBTN();

        List<WebElement> elements = driver.findElements(By.cssSelector("div[class=\"mb-3\"] div[class=\"error text-red\"]"));

        String actualMsg = "The email field is required., The email must be a valid email address.";

        try {
            actualMsg = driver.findElement(By.cssSelector("div[class=\"mb-3\"] div[class=\"error text-red\"]")).getText();
        } catch (NoSuchElementException e) {
            soft.fail("The email field is required., The email must be a valid email address.");
        }
        switch (actualMsg){
            case "The email field is required.":
                soft.assertTrue(false, "actualMsg: "+actualMsg+" | "+ "expectedMsg: "+"The email field is required.");
                break;
            case "The email must be a valid email address.":
                break;
        }
        soft.assertAll();
    }

    @Test (priority = 3, dataProvider = "Invalid phone number", dataProviderClass = P02DataDrivenPage.class)
    public void InvalidPhone (String phone)
    {
        home = new P01HomePage(driver);
        sign = new P03SignUpPage(driver);

        home.registerBTN();

        sign.signupBTN();
        sign.closeMenu();
        sign.fName("Kerolos");
        sign.lName("Emad");
        globalEmail = faker.internet().emailAddress();
        sign.email(globalEmail);
        sign.phone(phone);
        sign.pass("Test123!");
        sign.confPass("Test123!");
        sign.CreateBTN();
    }

    @Test (priority = 4, dataProvider = "Invalid password and confirm password", dataProviderClass = P02DataDrivenPage.class)
    public void InvalidPassAndConfPass (String pass, String ConfPass)
    {
        home = new P01HomePage(driver);
        sign = new P03SignUpPage(driver);

        home.registerBTN();

        sign.signupBTN();
        sign.closeMenu();
        sign.fName("Kerolos");
        sign.lName("Emad");
        globalEmail = faker.internet().emailAddress();
        sign.email(globalEmail);
        String phoneNumber = faker.numerify("010########");
        sign.phone(phoneNumber);
        sign.pass(pass);
        sign.confPass(ConfPass);
        sign.CreateBTN();

        List<WebElement> elements = driver.findElements(By.cssSelector("div[class=\"mb-3\"] div[class=\"error text-red\"]"));

        String actualMsg = "The email field is required., The email must be a valid email address.";

        try {
            actualMsg = driver.findElement(By.cssSelector("div[class=\"mb-3\"] div[class=\"error text-red\"]")).getText();
        } catch (NoSuchElementException e) {
            soft.fail("The password must be at least 8 characters.\n" +
                    "The password confirmation does not match., The password confirmation does not match.");
        }
        switch (actualMsg){
            case "The password must be at least 8 characters.\n" +
                    "The password confirmation does not match.":
                soft.assertTrue(false, "actualMsg: "+actualMsg+" | "+ "expectedMsg: "+"The email field is required.");
                break;
            case "The password confirmation does not match.":
                break;
        }
        soft.assertAll();
    }

    @Test (priority = 5, dataProvider = "use clear button", dataProviderClass = P02DataDrivenPage.class)
    public void clear (String FName, String LName, String email, String phone, String pass, String confPass)
    {
        home = new P01HomePage(driver);
        sign = new P03SignUpPage(driver);

        home.registerBTN();

        sign.signupBTN();
        sign.closeMenu();
        sign.fName(FName);
        sign.lName(LName);
        sign.email(email);
        sign.phone(phone);
        sign.pass(pass);
        sign.confPass(confPass);
        sign.clearBTN();
    }
}

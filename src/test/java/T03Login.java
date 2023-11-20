import Pages.P01HomePage;
import Pages.P02DataDrivenPage;
import Pages.P04LogInPage;
import org.testng.annotations.Test;

public class T03Login extends T01TestBase {

    protected P04LogInPage login;

    @Test (priority = 1, dataProvider = "Invalid login Email", dataProviderClass = P02DataDrivenPage.class)
    public void  InvalidLoginEmail (String mail, String pass)
    {
        home = new P01HomePage(driver);
        login = new P04LogInPage(driver);

        home.registerBTN();
        login.EnterEmail(mail);
        login.EnterPass(pass);
        login.signUPBTN();
    }

    @Test (priority = 2, dataProvider = "Invalid login Password", dataProviderClass = P02DataDrivenPage.class)
    public void InvalidLoginPass (String mail, String pass)
    {
        home = new P01HomePage(driver);
        login = new P04LogInPage(driver);

        home.registerBTN();
        login.EnterEmail(mail);
        login.EnterPass(pass);
        login.signUPBTN();
    }
}

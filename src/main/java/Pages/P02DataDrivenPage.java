package Pages;

import org.testng.annotations.DataProvider;

public class P02DataDrivenPage {

    @DataProvider(name = "Invalid first name and last name")
    public static Object [] [] Data ()
    {
        return new Object[][] {
                {"","Emad"},
                {"K","Emad"},
                {"Ke","Emad"},
                {"Kerolos",""},
                {"Kerolos","E"},
                {"Kerolos","Em"},
                {"Kerolos","Emad"}
        };
    }

    @DataProvider (name = "Invalid Email")
    public static Object [] [] InvalidData ()
    {
        return new Object[][] {
                {""},
                {"m.elzoghbi24gmail.com"},
                {"m.elzoghbi24@gmail"},
                {"@gmail.com"},
                {"m.elzoghbi24@@gmail.com"},
                {"m.elzoghbi24@-gmail.com"},
                {"m.elzoghbi24@ gmail.com"},
                {"m.elzoghbi24@gmail.com"},
        };
    }

    @DataProvider (name = "Invalid phone number")
    public static Object [] [] InvalidPhone ()
    {
        return new Object[][]
                {
                        {""},
                        {"0125489355"},
                        {"656587566882"},
                        {"0103358asd97"},
                        {"0103358477 5"},
                        {"01033584770"}
                };
    }

    @DataProvider (name = "Invalid password and confirm password")
    public static Object [] [] InvalidPassAndConfirmPass ()
    {
        return new Object[][] {
                {"fa123", "Fabrica123!"},
                {"Fabrica", "Fabrica123!"},
                {"fabrica123!", "Fabrica123!"},
                {"FABRICA123!", "Fabrica123!"},
                {"Fabrica123", "Fabrica123!"},
                {"12345678", "Fabrica123!"},
                {"@#%*&^!@ ", "Fabrica123!"},
                {"Fabrica 123!", "Fabrica123!"},
                {"Fabrica123!", ""},
                {"Fabrica123!", "Fabrica124!"},
                {"Fabrica123!", "fabrica123!"},
                {"Fabrica123!", "Fabrica 123!"},
                {"Fabrica123!", "kerolos123!"}
        };
    }

    @DataProvider (name = "use clear button")
    public static Object [] [] clearBtn()
    {
        return new Object[][] {
                {"Kerolos","Emad", "m.elzoghbi24gmail.com", "01033584770", "Test123!", "Test123!"}
        };
    }

    @DataProvider (name = "Invalid login Email")
    public static Object [] [] InvalidLoginEmail ()
    {
        return new Object[][] {
                {"", "12345678"},
                {"a@gmail.com", "12345678"},
                {"aly@gmail.com", "12345678"},
                {"ali@@gmail.com", "12345678"},
                {"ali@gamil.com", "12345678"},
                {"ali@gmail", "12345678"}
        };
    }

    @DataProvider (name = "Invalid login Password")
    public static Object [] [] InvalidLoginPass ()
    {
        return new Object[][] {
                {"ali@gmail.com", ""},
                {"ali@gmail.com", "1@2345678"},
                {"ali@gmail.com", "123k;45678"},
                {"ali@gmail.com", "123678"},
                {"ali@gmail.com", "123jl45678"},
                {"ali@gmail.com", "12345.//678"}
        };
    }
}

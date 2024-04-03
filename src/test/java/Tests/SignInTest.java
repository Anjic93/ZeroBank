package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class SignInTest extends BaseTest {

    HomePage homePage;
    LogInPage logInPage;


    @BeforeMethod
    public void pageSetUp() {
        WebDriver driver = new ChromeDriver();
        driverThreadLocal.set(driver);
        driver = driverThreadLocal.get();
        driver.get("http://zero.webappsecurity.com/index.html");
        driver.manage().window().maximize();


        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);


    }
    WebDriver driver = new ChromeDriver();
    String validUsername = "username";
    String validPassword = "password";

    String invalidUsername = "UsernamE";
    String invalidPassword = "PassworD";
    String emptyUsername = "";
    String emptyPassword = "";


    @Test(priority = 10)
    public void userCanSuccessfullyLogIn() {
        homePage.clickOnSignInButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html");


        logInPage.inputUsername(validUsername);
        logInPage.inputPassword(validPassword);
        logInPage.checkKeepMeSignedInCheckbox();
        logInPage.clickOnSignInButton();
        driver.navigate().back();
       //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/index.html");
        Assert.assertTrue(homePage.usernameIcon.isDisplayed());
    }

    @Test(priority = 20)
    public void userCanLogOut() {
        homePage.clickOnSignInButton();
       // Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html");

        logInPage.inputUsername(validUsername);
        logInPage.inputPassword(validPassword);
        logInPage.checkKeepMeSignedInCheckbox();
        logInPage.clickOnSignInButton();
        driver.navigate().back();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/index.html");
        //Assert.assertTrue(homePage.usernameIcon.isDisplayed());

        homePage.clickOnUsernameButton();
        homePage.clickOnLogoutButton();
       // Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/index.html");
        Assert.assertTrue(homePage.signInButton.isDisplayed());
    }

    @Test(priority = 30)
    public void userCantLoginWithInvalidUsername() {
        homePage.clickOnSignInButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html");

        logInPage.inputUsername(invalidUsername);
        logInPage.inputPassword(validPassword);
        logInPage.checkKeepMeSignedInCheckbox();
        logInPage.clickOnSignInButton();
       // Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html?login_error=true");
        logInPage.checkErrorMessage();
    }

    @Test(priority = 40)
    public void userCantLoginWithInvalidPassword() {
        homePage.clickOnSignInButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html");

        logInPage.inputUsername(validUsername);
        logInPage.inputPassword(invalidPassword);
        logInPage.checkKeepMeSignedInCheckbox();
        logInPage.clickOnSignInButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html?login_error=true");
        logInPage.checkErrorMessage();
    }


    @Test(priority = 50)
    public void userCantLoginWithInvalidUsernameAndInvalidPassword() {
        homePage.clickOnSignInButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html");

        logInPage.inputUsername(invalidUsername);
        logInPage.inputPassword(invalidPassword);
        logInPage.checkKeepMeSignedInCheckbox();
        logInPage.clickOnSignInButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html?login_error=true");
        logInPage.checkErrorMessage();
    }

    @Test(priority = 60)
    public void userCantLoginWithEmptyUsername() {
        homePage.clickOnSignInButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html");

        logInPage.inputUsername(emptyUsername);
        logInPage.inputPassword(validPassword);
        logInPage.checkKeepMeSignedInCheckbox();
        logInPage.clickOnSignInButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html?login_error=true");
        logInPage.checkErrorMessage();
    }

    @Test(priority = 70)
    public void userCantLoginWithEmptyPassword() {
        homePage.clickOnSignInButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html");

        logInPage.inputUsername(validUsername);
        logInPage.inputPassword(emptyPassword);
        logInPage.checkKeepMeSignedInCheckbox();
        logInPage.clickOnSignInButton();
       // Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html?login_error=true");
        logInPage.checkErrorMessage();
    }

    @Test(priority = 80)
    public void userCantLoginWithEmptyUsernameAndEmptyPassword() {
        homePage.clickOnSignInButton();
       // Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html");

        logInPage.inputUsername(emptyUsername);
        logInPage.inputPassword(emptyPassword);
        logInPage.checkKeepMeSignedInCheckbox();
        logInPage.clickOnSignInButton();
        //Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html?login_error=true");
        logInPage.checkErrorMessage();
    }


}
